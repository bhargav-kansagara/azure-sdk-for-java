// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.aad.configuration;

import com.azure.spring.cloud.autoconfigure.aad.AadClientRegistrationRepository;
import com.azure.spring.cloud.autoconfigure.aad.implementation.AadOauth2ClientRestOperationConfiguration;
import com.azure.spring.cloud.autoconfigure.aad.implementation.conditions.ClientCertificatePropertiesCondition;
import com.azure.spring.cloud.autoconfigure.aad.implementation.conditions.ClientRegistrationCondition;
import com.azure.spring.cloud.autoconfigure.aad.implementation.jwt.AadJwtClientAuthenticationParametersConverter;
import com.azure.spring.cloud.autoconfigure.aad.implementation.oauth2.AadOAuth2ClientAuthenticationJwkResolver;
import com.azure.spring.cloud.autoconfigure.aad.implementation.oauth2.JacksonHttpSessionOAuth2AuthorizedClientRepository;
import com.azure.spring.cloud.autoconfigure.aad.implementation.oauth2.OAuth2ClientAuthenticationJwkResolver;
import com.azure.spring.cloud.autoconfigure.aad.implementation.webapi.AadJwtBearerGrantRequestEntityConverter;
import com.azure.spring.cloud.autoconfigure.aad.implementation.webapp.AadAzureDelegatedOAuth2AuthorizedClientProvider;
import com.azure.spring.cloud.autoconfigure.aad.properties.AadAuthenticationProperties;
import com.nimbusds.jose.jwk.JWK;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.client.JwtBearerOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.RefreshTokenOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.endpoint.DefaultClientCredentialsTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.DefaultJwtBearerTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.DefaultPasswordTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.DefaultRefreshTokenTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2ClientCredentialsGrantRequestEntityConverter;
import org.springframework.security.oauth2.client.endpoint.OAuth2PasswordGrantRequestEntityConverter;
import org.springframework.security.oauth2.client.endpoint.OAuth2RefreshTokenGrantRequestEntityConverter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestOperations;

import static com.azure.spring.cloud.autoconfigure.aad.implementation.AadOauth2ClientRestOperationConfiguration.AAD_OAUTH_2_CLIENT_REST_OPERATION_BEAN_NAME;

/**
 * <p>
 * The configuration will not be activated if no {@link ClientRegistration} classes provided.
 * </p>
 */
@Configuration(proxyBeanMethods = false)
@Conditional(ClientRegistrationCondition.class)
@Import(AadOauth2ClientRestOperationConfiguration.class)
public class AadOAuth2ClientConfiguration {

    private final RestOperations restOperations;

    /**
     * Creates a new instance of {@link AadOAuth2ClientConfiguration}.
     *
     * @param restOperations the restOperations
     */
    public AadOAuth2ClientConfiguration(
            @Qualifier(AAD_OAUTH_2_CLIENT_REST_OPERATION_BEAN_NAME) RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    /**
     * Declare ClientRegistrationRepository bean.
     *
     * @param properties the AAD authentication properties
     * @return ClientRegistrationRepository bean
     */
    @Bean
    @ConditionalOnMissingBean
    public ClientRegistrationRepository clientRegistrationRepository(AadAuthenticationProperties properties) {
        return new AadClientRegistrationRepository(properties);
    }

    /**
     * Declare OAuth2AuthorizedClientRepository bean.
     *
     * @return OAuth2AuthorizedClientRepository bean
     */
    @Bean
    @ConditionalOnMissingBean
    public OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository() {
        return new JacksonHttpSessionOAuth2AuthorizedClientRepository();
    }

    /**
     * Return the resolver to resolve a {@link JWK} through the {@link ClientRegistration}.
     *
     * @param properties the AAD authentication properties
     * @return the function that will resolve out the JWK.
     */
    @Bean
    @ConditionalOnMissingBean
    @Conditional(ClientCertificatePropertiesCondition.class)
    OAuth2ClientAuthenticationJwkResolver oAuth2ClientAuthenticationJwkResolver(AadAuthenticationProperties properties) {
        return new AadOAuth2ClientAuthenticationJwkResolver(
            properties.getCredential().getClientCertificatePath(),
            properties.getCredential().getClientCertificatePassword());
    }

    /**
     * Declare OAuth2AuthorizedClientManager bean.
     *
     * @param clientRegistrations the client registration repository
     * @param authorizedClients the OAuth2 authorized client repository
     * @param refreshTokenProvider the refresh token grant type provider
     * @param jwtBearerProvider the jwt bearer grant type provider
     * @param jwkResolvers the {@link JWK} resolver
     * @return OAuth2AuthorizedClientManager bean
     */
    @Bean
    @ConditionalOnMissingBean
    OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrations,
            OAuth2AuthorizedClientRepository authorizedClients,
            RefreshTokenOAuth2AuthorizedClientProvider refreshTokenProvider,
            JwtBearerOAuth2AuthorizedClientProvider jwtBearerProvider,
            ObjectProvider<OAuth2ClientAuthenticationJwkResolver> jwkResolvers) {
        DefaultOAuth2AuthorizedClientManager manager =
            new DefaultOAuth2AuthorizedClientManager(clientRegistrations, authorizedClients);

        OAuth2ClientAuthenticationJwkResolver jwkResolver = jwkResolvers.getIfUnique();
        // @formatter:off
        OAuth2AuthorizedClientProvider providers =
            OAuth2AuthorizedClientProviderBuilder
                .builder()
                .authorizationCode()
                .clientCredentials(builder ->
                    clientCredentialsGrantBuilderAccessTokenResponseClientCustomizer(builder, jwkResolver))
                .password(builder -> passwordGrantBuilderAccessTokenResponseClientCustomizer(builder, jwkResolver))
                .provider(refreshTokenProvider)
                .provider(jwtBearerProvider)
                .provider(azureDelegatedOAuth2AuthorizedClientProvider(refreshTokenProvider, authorizedClients))
                .build();
        // @formatter:on
        manager.setAuthorizedClientProvider(providers);
        return manager;
    }

    @Bean
    @ConditionalOnMissingBean
    JwtBearerOAuth2AuthorizedClientProvider azureAdJwtBearerProvider(
            ObjectProvider<OAuth2ClientAuthenticationJwkResolver> resolvers) {
        JwtBearerOAuth2AuthorizedClientProvider provider = new JwtBearerOAuth2AuthorizedClientProvider();
        OAuth2ClientAuthenticationJwkResolver resolver = resolvers.getIfUnique();
        AadJwtBearerGrantRequestEntityConverter jwtBearerConverter = new AadJwtBearerGrantRequestEntityConverter();
        if (resolver != null) {
            jwtBearerConverter.addParametersConverter(new AadJwtClientAuthenticationParametersConverter<>(resolver::resolve));
        }
        DefaultJwtBearerTokenResponseClient responseClient = new DefaultJwtBearerTokenResponseClient();
        responseClient.setRestOperations(restOperations);
        responseClient.setRequestEntityConverter(jwtBearerConverter);
        provider.setAccessTokenResponseClient(responseClient);
        return provider;
    }

    @Bean
    @ConditionalOnMissingBean
    RefreshTokenOAuth2AuthorizedClientProvider azureRefreshTokenProvider(
            ObjectProvider<OAuth2ClientAuthenticationJwkResolver> resolvers) {
        RefreshTokenOAuth2AuthorizedClientProvider provider = new RefreshTokenOAuth2AuthorizedClientProvider();
        OAuth2ClientAuthenticationJwkResolver resolver = resolvers.getIfUnique();
        if (resolver != null) {
            OAuth2RefreshTokenGrantRequestEntityConverter converter = new OAuth2RefreshTokenGrantRequestEntityConverter();
            converter.addParametersConverter(new AadJwtClientAuthenticationParametersConverter<>(resolver::resolve));

            DefaultRefreshTokenTokenResponseClient responseClient = new DefaultRefreshTokenTokenResponseClient();
            responseClient.setRestOperations(restOperations);
            responseClient.setRequestEntityConverter(converter);
            provider.setAccessTokenResponseClient(responseClient);
        }
        return provider;
    }

    private void passwordGrantBuilderAccessTokenResponseClientCustomizer(
            OAuth2AuthorizedClientProviderBuilder.PasswordGrantBuilder builder,
            OAuth2ClientAuthenticationJwkResolver resolver) {
        if (resolver != null) {
            OAuth2PasswordGrantRequestEntityConverter converter = new OAuth2PasswordGrantRequestEntityConverter();
            converter.addParametersConverter(new AadJwtClientAuthenticationParametersConverter<>(resolver::resolve));

            DefaultPasswordTokenResponseClient client = new DefaultPasswordTokenResponseClient();
            client.setRestOperations(restOperations);
            client.setRequestEntityConverter(converter);

            builder.accessTokenResponseClient(client);
        }
    }

    private void clientCredentialsGrantBuilderAccessTokenResponseClientCustomizer(
            OAuth2AuthorizedClientProviderBuilder.ClientCredentialsGrantBuilder builder,
            OAuth2ClientAuthenticationJwkResolver resolver) {
        if (resolver != null) {
            OAuth2ClientCredentialsGrantRequestEntityConverter converter =
                new OAuth2ClientCredentialsGrantRequestEntityConverter();
            converter.addParametersConverter(new AadJwtClientAuthenticationParametersConverter<>(resolver::resolve));

            DefaultClientCredentialsTokenResponseClient client = new DefaultClientCredentialsTokenResponseClient();
            client.setRestOperations(restOperations);
            client.setRequestEntityConverter(converter);

            builder.accessTokenResponseClient(client);
        }
    }

    private AadAzureDelegatedOAuth2AuthorizedClientProvider azureDelegatedOAuth2AuthorizedClientProvider(
        RefreshTokenOAuth2AuthorizedClientProvider refreshTokenProvider,
        OAuth2AuthorizedClientRepository authorizedClients) {
        return new AadAzureDelegatedOAuth2AuthorizedClientProvider(refreshTokenProvider, authorizedClients);
    }
}
