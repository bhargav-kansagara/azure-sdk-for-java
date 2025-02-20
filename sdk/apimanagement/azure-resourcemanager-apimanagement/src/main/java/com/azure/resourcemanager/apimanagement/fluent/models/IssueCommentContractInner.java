// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Issue Comment Contract details. */
@Fluent
public final class IssueCommentContractInner extends ProxyResource {
    /*
     * Properties of the Issue Comment.
     */
    @JsonProperty(value = "properties")
    private IssueCommentContractProperties innerProperties;

    /**
     * Get the innerProperties property: Properties of the Issue Comment.
     *
     * @return the innerProperties value.
     */
    private IssueCommentContractProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the text property: Comment text.
     *
     * @return the text value.
     */
    public String text() {
        return this.innerProperties() == null ? null : this.innerProperties().text();
    }

    /**
     * Set the text property: Comment text.
     *
     * @param text the text value to set.
     * @return the IssueCommentContractInner object itself.
     */
    public IssueCommentContractInner withText(String text) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IssueCommentContractProperties();
        }
        this.innerProperties().withText(text);
        return this;
    }

    /**
     * Get the createdDate property: Date and time when the comment was created.
     *
     * @return the createdDate value.
     */
    public OffsetDateTime createdDate() {
        return this.innerProperties() == null ? null : this.innerProperties().createdDate();
    }

    /**
     * Set the createdDate property: Date and time when the comment was created.
     *
     * @param createdDate the createdDate value to set.
     * @return the IssueCommentContractInner object itself.
     */
    public IssueCommentContractInner withCreatedDate(OffsetDateTime createdDate) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IssueCommentContractProperties();
        }
        this.innerProperties().withCreatedDate(createdDate);
        return this;
    }

    /**
     * Get the userId property: A resource identifier for the user who left the comment.
     *
     * @return the userId value.
     */
    public String userId() {
        return this.innerProperties() == null ? null : this.innerProperties().userId();
    }

    /**
     * Set the userId property: A resource identifier for the user who left the comment.
     *
     * @param userId the userId value to set.
     * @return the IssueCommentContractInner object itself.
     */
    public IssueCommentContractInner withUserId(String userId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IssueCommentContractProperties();
        }
        this.innerProperties().withUserId(userId);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
