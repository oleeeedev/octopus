package dev.ole.octopus.client;

import dev.ole.octopus.dto.ApiResponse;
import dev.ole.octopus.dto.attribute.AttributeCreateRequest;
import dev.ole.octopus.dto.attribute.AttributeQueryRequest;
import dev.ole.octopus.dto.attribute.AttributeResponse;
import dev.ole.octopus.dto.log.LogCreateRequest;
import dev.ole.octopus.dto.log.LogQueryRequest;
import dev.ole.octopus.dto.log.LogResponse;
import dev.ole.octopus.dto.permission.PermissionCreateRequest;
import dev.ole.octopus.dto.permission.PermissionQueryRequest;
import dev.ole.octopus.dto.permission.PermissionResponse;
import dev.ole.octopus.dto.stat.StatCreateRequest;
import dev.ole.octopus.dto.stat.StatQueryRequest;
import dev.ole.octopus.dto.stat.StatResponse;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncApiClient {

    String getBaseUrl();

    URI getURI(String suffix);

    <T, S> CompletableFuture<T> postAsync(S request, URI route, Type type);

    <T> HttpRequest newRequest(T request, URI route);
    CompletableFuture<ApiResponse<AttributeResponse>> createRoleAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteRoleAttributesAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getRoleAttributesAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<PermissionResponse>> createRolePermissionAsync(PermissionCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteRolePermissionAsync(PermissionQueryRequest request);
    CompletableFuture<ApiResponse<List<PermissionResponse>>> getRolePermissionAsync(PermissionQueryRequest request);

    CompletableFuture<ApiResponse<AttributeResponse>> createServerAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteServerAttributeAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getServerAttributeAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<StatResponse>> createServerStatAsync(StatCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteServerStatAsync(StatQueryRequest request);
    CompletableFuture<ApiResponse<List<StatResponse>>> getServerStatAsync(StatQueryRequest request);

    CompletableFuture<ApiResponse<AttributeResponse>> createUserAttributeAsync(AttributeCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserAttributesAsync(AttributeQueryRequest request);
    CompletableFuture<ApiResponse<List<AttributeResponse>>> getUserAttributesAsync(AttributeQueryRequest request);

    CompletableFuture<ApiResponse<PermissionResponse>> createUserPermissionAsync(PermissionCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserPermissionAsync(PermissionQueryRequest request);
    CompletableFuture<ApiResponse<List<PermissionResponse>>> getUserPermissionAsync(PermissionQueryRequest request);

    CompletableFuture<ApiResponse<StatResponse>> createUserStatAsync(StatCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserStatAsync(StatQueryRequest request);
    CompletableFuture<ApiResponse<List<StatResponse>>> getUserStatAsync(StatQueryRequest request);

    CompletableFuture<ApiResponse<LogResponse>> createUserLogAsync(LogCreateRequest request);
    CompletableFuture<ApiResponse<Integer>> deleteUserLogAsync(LogQueryRequest request);
    CompletableFuture<ApiResponse<List<LogResponse>>> getUserLogAsync(LogQueryRequest request);}