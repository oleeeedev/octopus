package dev.ole.octopus.dto.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record PermissionResponse(@SerializedName("_id") @Expose String id,
                                 @SerializedName("namespace") @Expose String namespace,
                                 @SerializedName("target_id") @Expose String targetId,
                                 @SerializedName("permission_node") @Expose String permissionNode,
                                 @SerializedName("permission_value") @Expose Boolean permissionValue,
                                 @SerializedName("permission_priority") @Expose Integer permissionPriority,
                                 @SerializedName("created_at") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAt,
                                 @SerializedName("expired_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAt) {
}