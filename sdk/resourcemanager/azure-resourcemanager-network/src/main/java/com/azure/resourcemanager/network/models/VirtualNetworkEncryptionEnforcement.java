// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** If the encrypted VNet allows VM that does not support encryption. */
public final class VirtualNetworkEncryptionEnforcement
    extends ExpandableStringEnum<VirtualNetworkEncryptionEnforcement> {
    /** Static value DropUnencrypted for VirtualNetworkEncryptionEnforcement. */
    public static final VirtualNetworkEncryptionEnforcement DROP_UNENCRYPTED = fromString("DropUnencrypted");

    /** Static value AllowUnencrypted for VirtualNetworkEncryptionEnforcement. */
    public static final VirtualNetworkEncryptionEnforcement ALLOW_UNENCRYPTED = fromString("AllowUnencrypted");

    /**
     * Creates or finds a VirtualNetworkEncryptionEnforcement from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding VirtualNetworkEncryptionEnforcement.
     */
    @JsonCreator
    public static VirtualNetworkEncryptionEnforcement fromString(String name) {
        return fromString(name, VirtualNetworkEncryptionEnforcement.class);
    }

    /**
     * Gets known VirtualNetworkEncryptionEnforcement values.
     *
     * @return known VirtualNetworkEncryptionEnforcement values.
     */
    public static Collection<VirtualNetworkEncryptionEnforcement> values() {
        return values(VirtualNetworkEncryptionEnforcement.class);
    }
}
