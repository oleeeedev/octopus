package dev.ole.octopus.dto.attribute;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record AttributeQueryRequest(@SerializedName("namespace") @Expose String namespace,
                                    @SerializedName("target_id") @Expose String targetId,
                                    @SerializedName("attribute_key") @Expose String attributeKey,
                                    @SerializedName("created_after") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAfter,
                                    @SerializedName("created_before") @Expose @JsonAdapter(InstantAdapter.class) Instant createdBefore,
                                    @SerializedName("expired_after") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAfter,
                                    @SerializedName("expired_before") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredBefore) {
}