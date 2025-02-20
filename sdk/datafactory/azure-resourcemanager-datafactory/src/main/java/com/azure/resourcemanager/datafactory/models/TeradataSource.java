// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** A copy activity Teradata source. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("TeradataSource")
@Fluent
public final class TeradataSource extends TabularSource {
    /*
     * Teradata query. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "query")
    private Object query;

    /*
     * The partition mechanism that will be used for teradata read in parallel. Possible values include: "None",
     * "Hash", "DynamicRange".
     */
    @JsonProperty(value = "partitionOption")
    private Object partitionOption;

    /*
     * The settings that will be leveraged for teradata source partitioning.
     */
    @JsonProperty(value = "partitionSettings")
    private TeradataPartitionSettings partitionSettings;

    /**
     * Get the query property: Teradata query. Type: string (or Expression with resultType string).
     *
     * @return the query value.
     */
    public Object query() {
        return this.query;
    }

    /**
     * Set the query property: Teradata query. Type: string (or Expression with resultType string).
     *
     * @param query the query value to set.
     * @return the TeradataSource object itself.
     */
    public TeradataSource withQuery(Object query) {
        this.query = query;
        return this;
    }

    /**
     * Get the partitionOption property: The partition mechanism that will be used for teradata read in parallel.
     * Possible values include: "None", "Hash", "DynamicRange".
     *
     * @return the partitionOption value.
     */
    public Object partitionOption() {
        return this.partitionOption;
    }

    /**
     * Set the partitionOption property: The partition mechanism that will be used for teradata read in parallel.
     * Possible values include: "None", "Hash", "DynamicRange".
     *
     * @param partitionOption the partitionOption value to set.
     * @return the TeradataSource object itself.
     */
    public TeradataSource withPartitionOption(Object partitionOption) {
        this.partitionOption = partitionOption;
        return this;
    }

    /**
     * Get the partitionSettings property: The settings that will be leveraged for teradata source partitioning.
     *
     * @return the partitionSettings value.
     */
    public TeradataPartitionSettings partitionSettings() {
        return this.partitionSettings;
    }

    /**
     * Set the partitionSettings property: The settings that will be leveraged for teradata source partitioning.
     *
     * @param partitionSettings the partitionSettings value to set.
     * @return the TeradataSource object itself.
     */
    public TeradataSource withPartitionSettings(TeradataPartitionSettings partitionSettings) {
        this.partitionSettings = partitionSettings;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withQueryTimeout(Object queryTimeout) {
        super.withQueryTimeout(queryTimeout);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withAdditionalColumns(Object additionalColumns) {
        super.withAdditionalColumns(additionalColumns);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withSourceRetryCount(Object sourceRetryCount) {
        super.withSourceRetryCount(sourceRetryCount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withSourceRetryWait(Object sourceRetryWait) {
        super.withSourceRetryWait(sourceRetryWait);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.withMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TeradataSource withDisableMetricsCollection(Object disableMetricsCollection) {
        super.withDisableMetricsCollection(disableMetricsCollection);
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
        if (partitionSettings() != null) {
            partitionSettings().validate();
        }
    }
}
