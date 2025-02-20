// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.changefeed.incremental;

import com.azure.cosmos.implementation.Constants;
import com.azure.cosmos.implementation.InternalObjectNode;
import com.azure.cosmos.implementation.changefeed.Lease;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedStartFromInternal;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedState;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedStateV1;
import com.azure.cosmos.implementation.changefeed.common.LeaseVersion;
import com.azure.cosmos.implementation.feedranges.FeedRangeInternal;
import com.azure.cosmos.implementation.feedranges.FeedRangePartitionKeyRangeImpl;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedMode;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;

/**
 * Document service lease.
 */
@JsonSerialize(using = ServiceItemLease.ServiceItemLeaseJsonSerializer.class)
public class ServiceItemLease implements Lease {

    private String id;
    private String _etag;
    private String leaseToken;
    private String owner;
    private String continuationToken;

    private Map<String, String> properties;
    private String timestamp;  // ExplicitTimestamp
    private String _ts;

    public ServiceItemLease() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("UTC"));
        this.timestamp = currentTime.toString();
        this._ts = String.valueOf(currentTime.getSecond());
        this.properties = new HashMap<>();
    }

    public ServiceItemLease(ServiceItemLease other)
    {
        this.id = other.id;
        this._etag = other._etag;
        this.leaseToken = other.leaseToken;
        this.owner = other.owner;
        this.continuationToken = other.continuationToken;
        this.properties = other.properties;
        this.timestamp = other.timestamp;
        this._ts = other._ts;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public ServiceItemLease withId(String id) {
        this.id = id;
        return this;
    }

    public String getETag() {
        return this._etag;
    }

    public ServiceItemLease withETag(String etag) {
        this._etag = etag;
        return this;
    }

    public String getLeaseToken() {
        return this.leaseToken;
    }

    @Override
    public FeedRangeInternal getFeedRange() {
        return new FeedRangePartitionKeyRangeImpl(this.leaseToken);
    }

    public ServiceItemLease withLeaseToken(String leaseToken) {
        this.leaseToken = leaseToken;
        return this;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public LeaseVersion getVersion() {
        return LeaseVersion.PARTITION_KEY_BASED_LEASE;
    }

    public ServiceItemLease withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override
    public String getReadableContinuationToken() {
        return this.continuationToken;
    }

    @Override
    public ChangeFeedState getEpkRangeBasedContinuationState(String containerRid) {
        throw new UnsupportedOperationException("getEpkRangeBasedContinuationState() is not supported for V0 wire format");
    }

    @Override
    public ChangeFeedState getPartitionKeyBasedContinuationState(String containerRid, FeedRangeInternal feedRange) {
        checkNotNull(containerRid, "Argument 'containerRid' must not be null.");
        checkNotNull(feedRange, "Argument 'feedRange' must not be null.");

        return new ChangeFeedStateV1(
            containerRid,
            feedRange,
            ChangeFeedMode.INCREMENTAL,
            ChangeFeedStartFromInternal.createFromETagAndFeedRange(this.continuationToken, feedRange),
            null);
    }

    @Override
    public void setContinuationToken(String continuationToken) {
        this.withContinuationToken(continuationToken);
    }

    public ServiceItemLease withContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
        return this;
    }

    @Override
    public Map<String, String> getProperties() {
        return this.properties;
    }

    @Override
    public void setOwner(String owner) {
        this.withOwner(owner);
    }

    @Override
    public void setTimestamp(Instant timestamp) {
        this.withTimestamp(timestamp);
    }

    public void setTimestamp(Date date) {
        this.withTimestamp(date.toInstant());
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void setId(String id) {
        this.withId(id);
    }

    @Override
    public void setConcurrencyToken(String concurrencyToken) {
        this.withETag(concurrencyToken);
    }

    public ServiceItemLease withConcurrencyToken(String concurrencyToken) {
        return this.withETag(concurrencyToken);
    }

    @Override
    public void setProperties(Map<String, String> properties) {
        this.withProperties(properties);
    }

    public ServiceItemLease withProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    public String getTs() {
        return this._ts;
    }

    public ServiceItemLease withTs(String ts) {
        this._ts = ts;
        return this;
    }

    @Override
    public String getTimestamp() {
        if (this.timestamp == null) {
            return UNIX_START_TIME.plusSeconds(Long.parseLong(this.getTs())).toString();
        }
        return this.timestamp;
    }

    public ServiceItemLease withTimestamp(Instant timestamp) {
        this.timestamp = timestamp.toString();
        return this;
    }

    public String getExplicitTimestamp() {
        return this.timestamp;
    }

    @Override
    public String getConcurrencyToken() {
        return this.getETag();
    }

    @Override
    public void setVersion(LeaseVersion leaseVersion) {
    }

    @Override
    public void setFeedRange(FeedRangeInternal feedRangeInternal) {
    }

    public static ServiceItemLease fromDocument(InternalObjectNode document) {
        ServiceItemLease lease = new ServiceItemLease()
            .withId(document.getId())
            .withETag(document.getETag())
            .withTs(ModelBridgeInternal.getStringFromJsonSerializable(document, Constants.Properties.LAST_MODIFIED))
            .withOwner(ModelBridgeInternal.getStringFromJsonSerializable(document,PROPERTY_NAME_OWNER))
            .withLeaseToken(ModelBridgeInternal.getStringFromJsonSerializable(document,PROPERTY_NAME_LEASE_TOKEN))
            .withContinuationToken(ModelBridgeInternal.getStringFromJsonSerializable(document,PROPERTY_NAME_CONTINUATION_TOKEN));

        String leaseTimestamp = ModelBridgeInternal.getStringFromJsonSerializable(document,PROPERTY_NAME_TIMESTAMP);
        if (leaseTimestamp != null) {
            return lease.withTimestamp(ZonedDateTime.parse(leaseTimestamp).toInstant());
        } else {
            return lease;
        }
    }

    public void setServiceItemLease(Lease lease) {
        this.setId(lease.getId());
        this.setConcurrencyToken(lease.getConcurrencyToken());
        this.setOwner(lease.getOwner());
        this.withLeaseToken(lease.getLeaseToken());
        this.setContinuationToken(getContinuationToken());

        String leaseTimestamp = lease.getTimestamp();
        if (leaseTimestamp != null) {
            this.setTimestamp(ZonedDateTime.parse(leaseTimestamp).toInstant());
        } else {
            this.setTimestamp(lease.getTimestamp());
        }
    }

    @Override
    public String toString() {
        return String.format(
            "%s Owner='%s' Continuation=%s Timestamp(local)=%s Timestamp(server)=%s",
            this.getId(),
            this.getOwner(),
            this.getReadableContinuationToken(),
            this.getTimestamp(),
            UNIX_START_TIME.plusSeconds(Long.parseLong(this.getTs())));
    }

    @SuppressWarnings("serial")
    static final class ServiceItemLeaseJsonSerializer extends StdSerializer<ServiceItemLease> {
        // this value should be incremented if changes are made to the ServiceItemLease class members
        private static final long serialVersionUID = 1L;

        protected ServiceItemLeaseJsonSerializer() { this(null); }

        protected ServiceItemLeaseJsonSerializer(Class<ServiceItemLease> t) {
            super(t);
        }

        @Override
        public void serialize(ServiceItemLease lease, JsonGenerator writer, SerializerProvider serializerProvider) {
            try {
                writer.writeStartObject();
                writer.writeStringField(Constants.Properties.ID, lease.getId());
                writer.writeStringField(Constants.Properties.E_TAG, lease.getETag());
                writer.writeStringField(PROPERTY_NAME_LEASE_TOKEN, lease.getLeaseToken());
                writer.writeStringField(PROPERTY_NAME_CONTINUATION_TOKEN, lease.getContinuationToken());
                writer.writeStringField(PROPERTY_NAME_TIMESTAMP, lease.getTimestamp());
                writer.writeStringField(PROPERTY_NAME_OWNER, lease.getOwner());
                writer.writeEndObject();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
