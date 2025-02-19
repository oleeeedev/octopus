package dev.ole.octopus.dto.attribute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record AttributeResponse(@SerializedName("_id") @Expose String id,
                                @SerializedName("namespace") @Expose String namespace,
                                @SerializedName("attribute_key") @Expose String attributeKey,
                                @SerializedName("attribute_value") @Expose String attributeValue,
                                @JsonAdapter(InstantAdapter.class) @SerializedName("created_at") @Expose Instant createdAt,
                                @JsonAdapter(InstantAdapter.class) @SerializedName("expired_at") @Expose Instant expiredAt) {
}