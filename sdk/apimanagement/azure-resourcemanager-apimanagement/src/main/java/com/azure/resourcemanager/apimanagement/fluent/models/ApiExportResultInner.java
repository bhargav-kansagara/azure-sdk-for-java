// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.apimanagement.models.ApiExportResultValue;
import com.azure.resourcemanager.apimanagement.models.ExportResultFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/** API Export result. */
@Fluent
public final class ApiExportResultInner {
    /*
     * ResourceId of the API which was exported.
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * Format in which the API Details are exported to the Storage Blob with
     * Sas Key valid for 5 minutes.
     */
    @JsonProperty(value = "format")
    private ExportResultFormat exportResultFormat;

    /*
     * The object defining the schema of the exported API Detail
     */
    @JsonProperty(value = "value")
    private ApiExportResultValue value;

    /**
     * Get the id property: ResourceId of the API which was exported.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: ResourceId of the API which was exported.
     *
     * @param id the id value to set.
     * @return the ApiExportResultInner object itself.
     */
    public ApiExportResultInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the exportResultFormat property: Format in which the API Details are exported to the Storage Blob with Sas
     * Key valid for 5 minutes.
     *
     * @return the exportResultFormat value.
     */
    public ExportResultFormat exportResultFormat() {
        return this.exportResultFormat;
    }

    /**
     * Set the exportResultFormat property: Format in which the API Details are exported to the Storage Blob with Sas
     * Key valid for 5 minutes.
     *
     * @param exportResultFormat the exportResultFormat value to set.
     * @return the ApiExportResultInner object itself.
     */
    public ApiExportResultInner withExportResultFormat(ExportResultFormat exportResultFormat) {
        this.exportResultFormat = exportResultFormat;
        return this;
    }

    /**
     * Get the value property: The object defining the schema of the exported API Detail.
     *
     * @return the value value.
     */
    public ApiExportResultValue value() {
        return this.value;
    }

    /**
     * Set the value property: The object defining the schema of the exported API Detail.
     *
     * @param value the value value to set.
     * @return the ApiExportResultInner object itself.
     */
    public ApiExportResultInner withValue(ApiExportResultValue value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().validate();
        }
    }
}
