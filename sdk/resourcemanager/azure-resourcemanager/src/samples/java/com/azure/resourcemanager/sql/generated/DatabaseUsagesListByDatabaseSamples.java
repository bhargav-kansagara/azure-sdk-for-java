// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

import com.azure.core.util.Context;

/** Samples for DatabaseUsages ListByDatabase. */
public final class DatabaseUsagesListByDatabaseSamples {
    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/stable/2014-04-01/examples/DatabaseUsageMetricsList.json
     */
    /**
     * Sample code: List database usage metrics.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void listDatabaseUsageMetrics(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .sqlServers()
            .manager()
            .serviceClient()
            .getDatabaseUsages()
            .listByDatabase("sqlcrudtest-6730", "sqlcrudtest-9007", "3481", Context.NONE);
    }
}
