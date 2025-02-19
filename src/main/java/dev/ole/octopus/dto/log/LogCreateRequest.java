package dev.ole.octopus.dto.log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public record LogCreateRequest(@SerializedName("namespace") @Expose String namespace,
                               @SerializedName("target_id") @Expose String targetId,
                               @SerializedName("level") @Expose String level,
                               @SerializedName("message") @Expose String message) {
}