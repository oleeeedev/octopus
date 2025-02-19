package dev.ole.octopus.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public record ApiResponse<T>(@SerializedName("code") @Expose Integer code, @SerializedName("body") @Expose T body) {
}