// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.workloads.fluent.models.SapAvailabilityZoneDetailsResultInner;
import com.azure.resourcemanager.workloads.fluent.models.SapDiskConfigurationsResultInner;
import com.azure.resourcemanager.workloads.fluent.models.SapSizingRecommendationResultInner;
import com.azure.resourcemanager.workloads.fluent.models.SapSupportedResourceSkusResultInner;
import com.azure.resourcemanager.workloads.models.SapAvailabilityZoneDetailsRequest;
import com.azure.resourcemanager.workloads.models.SapDiskConfigurationsRequest;
import com.azure.resourcemanager.workloads.models.SapSizingRecommendationRequest;
import com.azure.resourcemanager.workloads.models.SapSupportedSkusRequest;

/** An instance of this class provides access to all the operations defined in ResourceProvidersClient. */
public interface ResourceProvidersClient {
    /**
     * Get SAP sizing recommendations.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP sizing recommendations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapSizingRecommendationResultInner sapSizingRecommendations(String location);

    /**
     * Get SAP sizing recommendations.
     *
     * @param location The name of Azure region.
     * @param sapSizingRecommendation SAP Sizing Recommendation Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP sizing recommendations along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapSizingRecommendationResultInner> sapSizingRecommendationsWithResponse(
        String location, SapSizingRecommendationRequest sapSizingRecommendation, Context context);

    /**
     * Get SAP supported SKUs.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP supported SKUs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapSupportedResourceSkusResultInner sapSupportedSku(String location);

    /**
     * Get SAP supported SKUs.
     *
     * @param location The name of Azure region.
     * @param sapSupportedSku SAP Supported SKU Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP supported SKUs along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapSupportedResourceSkusResultInner> sapSupportedSkuWithResponse(
        String location, SapSupportedSkusRequest sapSupportedSku, Context context);

    /**
     * Get SAP Disk Configurations.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Disk Configurations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapDiskConfigurationsResultInner sapDiskConfigurations(String location);

    /**
     * Get SAP Disk Configurations.
     *
     * @param location The name of Azure region.
     * @param sapDiskConfigurations SAP Disk Configurations Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Disk Configurations along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapDiskConfigurationsResultInner> sapDiskConfigurationsWithResponse(
        String location, SapDiskConfigurationsRequest sapDiskConfigurations, Context context);

    /**
     * Get SAP Availability Zone Details.
     *
     * @param location The name of Azure region.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Availability Zone Details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapAvailabilityZoneDetailsResultInner sapAvailabilityZoneDetails(String location);

    /**
     * Get SAP Availability Zone Details.
     *
     * @param location The name of Azure region.
     * @param sapAvailabilityZoneDetails SAP Availability Zone Details Request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP Availability Zone Details along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapAvailabilityZoneDetailsResultInner> sapAvailabilityZoneDetailsWithResponse(
        String location, SapAvailabilityZoneDetailsRequest sapAvailabilityZoneDetails, Context context);
}
