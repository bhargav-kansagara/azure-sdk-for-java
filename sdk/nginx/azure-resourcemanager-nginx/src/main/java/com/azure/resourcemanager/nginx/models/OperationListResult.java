// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.nginx.fluent.models.OperationResultInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Result of GET request to list Nginx.NginxPlus operations. */
@Fluent
public final class OperationListResult {
    /*
     * List of operations supported by the Nginx.NginxPlus provider.
     */
    @JsonProperty(value = "value")
    private List<OperationResultInner> value;

    /*
     * URL to get the next set of operation list results if there are any.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: List of operations supported by the Nginx.NginxPlus provider.
     *
     * @return the value value.
     */
    public List<OperationResultInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of operations supported by the Nginx.NginxPlus provider.
     *
     * @param value the value value to set.
     * @return the OperationListResult object itself.
     */
    public OperationListResult withValue(List<OperationResultInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: URL to get the next set of operation list results if there are any.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: URL to get the next set of operation list results if there are any.
     *
     * @param nextLink the nextLink value to set.
     * @return the OperationListResult object itself.
     */
    public OperationListResult withNextLink(String nextLink) {
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
