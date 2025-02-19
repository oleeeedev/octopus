package dev.ole.octopus.dto.log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.ole.octopus.adapter.InstantAdapter;

import java.time.Instant;

public record LogQueryRequest(@SerializedName("namespace") @Expose String namespace,
                              @SerializedName("target_id") @Expose String targetId,
                              @SerializedName("level") @Expose String level,
                              @SerializedName("created_after") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAfter,
                              @SerializedName("created_before") @Expose @JsonAdapter(InstantAdapter.class) Instant createdBefore) {
}