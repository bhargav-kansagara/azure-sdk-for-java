// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for LogSizeUnit. */
public final class LogSizeUnit extends ExpandableStringEnum<LogSizeUnit> {
    /** Static value Megabytes for LogSizeUnit. */
    public static final LogSizeUnit MEGABYTES = fromString("Megabytes");

    /** Static value Gigabytes for LogSizeUnit. */
    public static final LogSizeUnit GIGABYTES = fromString("Gigabytes");

    /** Static value Terabytes for LogSizeUnit. */
    public static final LogSizeUnit TERABYTES = fromString("Terabytes");

    /** Static value Petabytes for LogSizeUnit. */
    public static final LogSizeUnit PETABYTES = fromString("Petabytes");

    /** Static value Percent for LogSizeUnit. */
    public static final LogSizeUnit PERCENT = fromString("Percent");

    /**
     * Creates or finds a LogSizeUnit from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding LogSizeUnit.
     */
    @JsonCreator
    public static LogSizeUnit fromString(String name) {
        return fromString(name, LogSizeUnit.class);
    }

    /**
     * Gets known LogSizeUnit values.
     *
     * @return known LogSizeUnit values.
     */
    public static Collection<LogSizeUnit> values() {
        return values(LogSizeUnit.class);
    }
}
