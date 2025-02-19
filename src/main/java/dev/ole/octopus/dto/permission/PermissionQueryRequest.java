package dev.ole.octopus.dto.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record PermissionQueryRequest(@SerializedName("namespace") @Expose String namespace,
                                     @SerializedName("target_id") @Expose String targetId,
                                     @SerializedName("permission_node") @Expose String permissionNode,
                                     @SerializedName("permission_value") @Expose Boolean permissionValue,
                                     @SerializedName("priority_above") @Expose Integer priorityAbove,
                                     @SerializedName("priority_below") @Expose Integer priorityBelow,
                                     @SerializedName("created_after") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAfter,
                                     @SerializedName("created_before") @Expose @JsonAdapter(InstantAdapter.class) Instant createdBefore,
                                     @SerializedName("expired_after") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAfter,
                                     @SerializedName("expired_before") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredBefore) {
}