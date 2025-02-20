// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Describes a virtual machine scale set OS profile. */
@Fluent
public final class VirtualMachineScaleSetOSProfile {
    /*
     * Specifies the computer name prefix for all of the virtual machines in the scale set. Computer name prefixes must
     * be 1 to 15 characters long.
     */
    @JsonProperty(value = "computerNamePrefix")
    private String computerNamePrefix;

    /*
     * Specifies the name of the administrator account. <br><br> **Windows-only restriction:** Cannot end in "."
     * <br><br> **Disallowed values:** "administrator", "admin", "user", "user1", "test", "user2", "test1", "user3",
     * "admin1", "1", "123", "a", "actuser", "adm", "admin2", "aspnet", "backup", "console", "david", "guest", "john",
     * "owner", "root", "server", "sql", "support", "support_388945a0", "sys", "test2", "test3", "user4", "user5".
     * <br><br> **Minimum-length (Linux):** 1  character <br><br> **Max-length (Linux):** 64 characters <br><br>
     * **Max-length (Windows):** 20 characters
     */
    @JsonProperty(value = "adminUsername")
    private String adminUsername;

    /*
     * Specifies the password of the administrator account. <br><br> **Minimum-length (Windows):** 8 characters
     * <br><br> **Minimum-length (Linux):** 6 characters <br><br> **Max-length (Windows):** 123 characters <br><br>
     * **Max-length (Linux):** 72 characters <br><br> **Complexity requirements:** 3 out of 4 conditions below need to
     * be fulfilled <br> Has lower characters <br>Has upper characters <br> Has a digit <br> Has a special character
     * (Regex match [\W_]) <br><br> **Disallowed values:** "abc@123", "P@$$w0rd", "P@ssw0rd", "P@ssword123",
     * "Pa$$word", "pass@word1", "Password!", "Password1", "Password22", "iloveyou!" <br><br> For resetting the
     * password, see [How to reset the Remote Desktop service or its login password in a Windows
     * VM](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/reset-rdp) <br><br> For resetting root
     * password, see [Manage users, SSH, and check or repair disks on Azure Linux VMs using the VMAccess
     * Extension](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/troubleshoot-ssh-connection)
     */
    @JsonProperty(value = "adminPassword")
    private String adminPassword;

    /*
     * Specifies a base-64 encoded string of custom data. The base-64 encoded string is decoded to a binary array that
     * is saved as a file on the Virtual Machine. The maximum length of the binary array is 65535 bytes. <br><br> For
     * using cloud-init for your VM, see [Using cloud-init to customize a Linux VM during
     * creation](https://docs.microsoft.com/azure/virtual-machines/linux/using-cloud-init)
     */
    @JsonProperty(value = "customData")
    private String customData;

    /*
     * Specifies Windows operating system settings on the virtual machine.
     */
    @JsonProperty(value = "windowsConfiguration")
    private WindowsConfiguration windowsConfiguration;

    /*
     * Specifies the Linux operating system settings on the virtual machine. <br><br>For a list of supported Linux
     * distributions, see [Linux on Azure-Endorsed
     * Distributions](https://docs.microsoft.com/azure/virtual-machines/linux/endorsed-distros).
     */
    @JsonProperty(value = "linuxConfiguration")
    private LinuxConfiguration linuxConfiguration;

    /*
     * Specifies set of certificates that should be installed onto the virtual machines in the scale set. To install
     * certificates on a virtual machine it is recommended to use the [Azure Key Vault virtual machine extension for
     * Linux](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-linux) or the [Azure Key Vault
     * virtual machine extension for
     * Windows](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-windows).
     */
    @JsonProperty(value = "secrets")
    private List<VaultSecretGroup> secrets;

    /*
     * Specifies whether extension operations should be allowed on the virtual machine scale set. <br><br>This may only
     * be set to False when no extensions are present on the virtual machine scale set.
     */
    @JsonProperty(value = "allowExtensionOperations")
    private Boolean allowExtensionOperations;

    /**
     * Get the computerNamePrefix property: Specifies the computer name prefix for all of the virtual machines in the
     * scale set. Computer name prefixes must be 1 to 15 characters long.
     *
     * @return the computerNamePrefix value.
     */
    public String computerNamePrefix() {
        return this.computerNamePrefix;
    }

    /**
     * Set the computerNamePrefix property: Specifies the computer name prefix for all of the virtual machines in the
     * scale set. Computer name prefixes must be 1 to 15 characters long.
     *
     * @param computerNamePrefix the computerNamePrefix value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withComputerNamePrefix(String computerNamePrefix) {
        this.computerNamePrefix = computerNamePrefix;
        return this;
    }

    /**
     * Get the adminUsername property: Specifies the name of the administrator account. &lt;br&gt;&lt;br&gt;
     * **Windows-only restriction:** Cannot end in "." &lt;br&gt;&lt;br&gt; **Disallowed values:** "administrator",
     * "admin", "user", "user1", "test", "user2", "test1", "user3", "admin1", "1", "123", "a", "actuser", "adm",
     * "admin2", "aspnet", "backup", "console", "david", "guest", "john", "owner", "root", "server", "sql", "support",
     * "support_388945a0", "sys", "test2", "test3", "user4", "user5". &lt;br&gt;&lt;br&gt; **Minimum-length (Linux):** 1
     * character &lt;br&gt;&lt;br&gt; **Max-length (Linux):** 64 characters &lt;br&gt;&lt;br&gt; **Max-length
     * (Windows):** 20 characters.
     *
     * @return the adminUsername value.
     */
    public String adminUsername() {
        return this.adminUsername;
    }

    /**
     * Set the adminUsername property: Specifies the name of the administrator account. &lt;br&gt;&lt;br&gt;
     * **Windows-only restriction:** Cannot end in "." &lt;br&gt;&lt;br&gt; **Disallowed values:** "administrator",
     * "admin", "user", "user1", "test", "user2", "test1", "user3", "admin1", "1", "123", "a", "actuser", "adm",
     * "admin2", "aspnet", "backup", "console", "david", "guest", "john", "owner", "root", "server", "sql", "support",
     * "support_388945a0", "sys", "test2", "test3", "user4", "user5". &lt;br&gt;&lt;br&gt; **Minimum-length (Linux):** 1
     * character &lt;br&gt;&lt;br&gt; **Max-length (Linux):** 64 characters &lt;br&gt;&lt;br&gt; **Max-length
     * (Windows):** 20 characters.
     *
     * @param adminUsername the adminUsername value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
        return this;
    }

    /**
     * Get the adminPassword property: Specifies the password of the administrator account. &lt;br&gt;&lt;br&gt;
     * **Minimum-length (Windows):** 8 characters &lt;br&gt;&lt;br&gt; **Minimum-length (Linux):** 6 characters
     * &lt;br&gt;&lt;br&gt; **Max-length (Windows):** 123 characters &lt;br&gt;&lt;br&gt; **Max-length (Linux):** 72
     * characters &lt;br&gt;&lt;br&gt; **Complexity requirements:** 3 out of 4 conditions below need to be fulfilled
     * &lt;br&gt; Has lower characters &lt;br&gt;Has upper characters &lt;br&gt; Has a digit &lt;br&gt; Has a special
     * character (Regex match [\W_]) &lt;br&gt;&lt;br&gt; **Disallowed values:** "abc@123", "P@$$w0rd", "P@ssw0rd",
     * "P@ssword123", "Pa$$word", "pass@word1", "Password!", "Password1", "Password22", "iloveyou!" &lt;br&gt;&lt;br&gt;
     * For resetting the password, see [How to reset the Remote Desktop service or its login password in a Windows
     * VM](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/reset-rdp) &lt;br&gt;&lt;br&gt; For resetting
     * root password, see [Manage users, SSH, and check or repair disks on Azure Linux VMs using the VMAccess
     * Extension](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/troubleshoot-ssh-connection).
     *
     * @return the adminPassword value.
     */
    public String adminPassword() {
        return this.adminPassword;
    }

    /**
     * Set the adminPassword property: Specifies the password of the administrator account. &lt;br&gt;&lt;br&gt;
     * **Minimum-length (Windows):** 8 characters &lt;br&gt;&lt;br&gt; **Minimum-length (Linux):** 6 characters
     * &lt;br&gt;&lt;br&gt; **Max-length (Windows):** 123 characters &lt;br&gt;&lt;br&gt; **Max-length (Linux):** 72
     * characters &lt;br&gt;&lt;br&gt; **Complexity requirements:** 3 out of 4 conditions below need to be fulfilled
     * &lt;br&gt; Has lower characters &lt;br&gt;Has upper characters &lt;br&gt; Has a digit &lt;br&gt; Has a special
     * character (Regex match [\W_]) &lt;br&gt;&lt;br&gt; **Disallowed values:** "abc@123", "P@$$w0rd", "P@ssw0rd",
     * "P@ssword123", "Pa$$word", "pass@word1", "Password!", "Password1", "Password22", "iloveyou!" &lt;br&gt;&lt;br&gt;
     * For resetting the password, see [How to reset the Remote Desktop service or its login password in a Windows
     * VM](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/reset-rdp) &lt;br&gt;&lt;br&gt; For resetting
     * root password, see [Manage users, SSH, and check or repair disks on Azure Linux VMs using the VMAccess
     * Extension](https://docs.microsoft.com/troubleshoot/azure/virtual-machines/troubleshoot-ssh-connection).
     *
     * @param adminPassword the adminPassword value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    /**
     * Get the customData property: Specifies a base-64 encoded string of custom data. The base-64 encoded string is
     * decoded to a binary array that is saved as a file on the Virtual Machine. The maximum length of the binary array
     * is 65535 bytes. &lt;br&gt;&lt;br&gt; For using cloud-init for your VM, see [Using cloud-init to customize a Linux
     * VM during creation](https://docs.microsoft.com/azure/virtual-machines/linux/using-cloud-init).
     *
     * @return the customData value.
     */
    public String customData() {
        return this.customData;
    }

    /**
     * Set the customData property: Specifies a base-64 encoded string of custom data. The base-64 encoded string is
     * decoded to a binary array that is saved as a file on the Virtual Machine. The maximum length of the binary array
     * is 65535 bytes. &lt;br&gt;&lt;br&gt; For using cloud-init for your VM, see [Using cloud-init to customize a Linux
     * VM during creation](https://docs.microsoft.com/azure/virtual-machines/linux/using-cloud-init).
     *
     * @param customData the customData value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withCustomData(String customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Get the windowsConfiguration property: Specifies Windows operating system settings on the virtual machine.
     *
     * @return the windowsConfiguration value.
     */
    public WindowsConfiguration windowsConfiguration() {
        return this.windowsConfiguration;
    }

    /**
     * Set the windowsConfiguration property: Specifies Windows operating system settings on the virtual machine.
     *
     * @param windowsConfiguration the windowsConfiguration value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withWindowsConfiguration(WindowsConfiguration windowsConfiguration) {
        this.windowsConfiguration = windowsConfiguration;
        return this;
    }

    /**
     * Get the linuxConfiguration property: Specifies the Linux operating system settings on the virtual machine.
     * &lt;br&gt;&lt;br&gt;For a list of supported Linux distributions, see [Linux on Azure-Endorsed
     * Distributions](https://docs.microsoft.com/azure/virtual-machines/linux/endorsed-distros).
     *
     * @return the linuxConfiguration value.
     */
    public LinuxConfiguration linuxConfiguration() {
        return this.linuxConfiguration;
    }

    /**
     * Set the linuxConfiguration property: Specifies the Linux operating system settings on the virtual machine.
     * &lt;br&gt;&lt;br&gt;For a list of supported Linux distributions, see [Linux on Azure-Endorsed
     * Distributions](https://docs.microsoft.com/azure/virtual-machines/linux/endorsed-distros).
     *
     * @param linuxConfiguration the linuxConfiguration value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withLinuxConfiguration(LinuxConfiguration linuxConfiguration) {
        this.linuxConfiguration = linuxConfiguration;
        return this;
    }

    /**
     * Get the secrets property: Specifies set of certificates that should be installed onto the virtual machines in the
     * scale set. To install certificates on a virtual machine it is recommended to use the [Azure Key Vault virtual
     * machine extension for Linux](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-linux) or the
     * [Azure Key Vault virtual machine extension for
     * Windows](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-windows).
     *
     * @return the secrets value.
     */
    public List<VaultSecretGroup> secrets() {
        return this.secrets;
    }

    /**
     * Set the secrets property: Specifies set of certificates that should be installed onto the virtual machines in the
     * scale set. To install certificates on a virtual machine it is recommended to use the [Azure Key Vault virtual
     * machine extension for Linux](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-linux) or the
     * [Azure Key Vault virtual machine extension for
     * Windows](https://docs.microsoft.com/azure/virtual-machines/extensions/key-vault-windows).
     *
     * @param secrets the secrets value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withSecrets(List<VaultSecretGroup> secrets) {
        this.secrets = secrets;
        return this;
    }

    /**
     * Get the allowExtensionOperations property: Specifies whether extension operations should be allowed on the
     * virtual machine scale set. &lt;br&gt;&lt;br&gt;This may only be set to False when no extensions are present on
     * the virtual machine scale set.
     *
     * @return the allowExtensionOperations value.
     */
    public Boolean allowExtensionOperations() {
        return this.allowExtensionOperations;
    }

    /**
     * Set the allowExtensionOperations property: Specifies whether extension operations should be allowed on the
     * virtual machine scale set. &lt;br&gt;&lt;br&gt;This may only be set to False when no extensions are present on
     * the virtual machine scale set.
     *
     * @param allowExtensionOperations the allowExtensionOperations value to set.
     * @return the VirtualMachineScaleSetOSProfile object itself.
     */
    public VirtualMachineScaleSetOSProfile withAllowExtensionOperations(Boolean allowExtensionOperations) {
        this.allowExtensionOperations = allowExtensionOperations;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (windowsConfiguration() != null) {
            windowsConfiguration().validate();
        }
        if (linuxConfiguration() != null) {
            linuxConfiguration().validate();
        }
        if (secrets() != null) {
            secrets().forEach(e -> e.validate());
        }
    }
}
