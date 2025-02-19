package dev.ole.octopus.dto.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record StatQueryRequest(@SerializedName("namespace") @Expose String namespace,
                               @SerializedName("target_id") @Expose String targetId,
                               @SerializedName("stat_key") @Expose String statKey,
                               @SerializedName("stat_value_above") @Expose Integer statValueAbove,
                               @SerializedName("stat_value_below") @Expose Integer statValueBelow,
                               @SerializedName("created_after") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAfter,
                               @SerializedName("created_before") @Expose @JsonAdapter(InstantAdapter.class) Instant createdBefore,
                               @SerializedName("expired_after") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAfter,
                               @SerializedName("expired_before") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredBefore) {
}