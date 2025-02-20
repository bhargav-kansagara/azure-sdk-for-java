// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** workbookChartLineFormat. */
@Fluent
public final class MicrosoftGraphWorkbookChartLineFormat extends MicrosoftGraphEntity {
    /*
     * HTML color code representing the color of lines in the chart.
     */
    @JsonProperty(value = "color")
    private String color;

    /*
     * workbookChartLineFormat
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the color property: HTML color code representing the color of lines in the chart.
     *
     * @return the color value.
     */
    public String color() {
        return this.color;
    }

    /**
     * Set the color property: HTML color code representing the color of lines in the chart.
     *
     * @param color the color value to set.
     * @return the MicrosoftGraphWorkbookChartLineFormat object itself.
     */
    public MicrosoftGraphWorkbookChartLineFormat withColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Get the additionalProperties property: workbookChartLineFormat.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: workbookChartLineFormat.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphWorkbookChartLineFormat object itself.
     */
    public MicrosoftGraphWorkbookChartLineFormat withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void withAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public MicrosoftGraphWorkbookChartLineFormat withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
