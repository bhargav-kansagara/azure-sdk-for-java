// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.cdn.fluent.models.CustomDomainInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Result of the request to list custom domains. It contains a list of custom domain objects and a URL link to get the
 * next set of results.
 */
@Fluent
public final class CustomDomainListResult {
    /*
     * List of CDN CustomDomains within an endpoint.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<CustomDomainInner> value;

    /*
     * URL to get the next set of custom domain objects if there are any.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: List of CDN CustomDomains within an endpoint.
     *
     * @return the value value.
     */
    public List<CustomDomainInner> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: URL to get the next set of custom domain objects if there are any.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: URL to get the next set of custom domain objects if there are any.
     *
     * @param nextLink the nextLink value to set.
     * @return the CustomDomainListResult object itself.
     */
    public CustomDomainListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
