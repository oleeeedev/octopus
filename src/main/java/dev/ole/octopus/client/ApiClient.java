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

public interface ApiClient {

    String getBaseUrl();

    URI getURI(String suffix);

    <T, S> T post(S request, URI route, Type type);

    <T> HttpRequest newRequest(T request, URI route);

    ApiResponse<AttributeResponse> createRoleAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteRoleAttributes(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getRoleAttributes(AttributeQueryRequest request);

    ApiResponse<PermissionResponse> createRolePermission(PermissionCreateRequest request);
    ApiResponse<Integer> deleteRolePermission(PermissionQueryRequest request);
    ApiResponse<List<PermissionResponse>> getRolePermission(PermissionQueryRequest request);

    ApiResponse<AttributeResponse> createServerAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteServerAttribute(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getServerAttribute(AttributeQueryRequest request);

    ApiResponse<StatResponse> createServerStat(StatCreateRequest request);
    ApiResponse<Integer> deleteServerStat(StatQueryRequest request);
    ApiResponse<List<StatResponse>> getServerStat(StatQueryRequest request);

    ApiResponse<AttributeResponse> createUserAttribute(AttributeCreateRequest request);
    ApiResponse<Integer> deleteUserAttributes(AttributeQueryRequest request);
    ApiResponse<List<AttributeResponse>> getUserAttributes(AttributeQueryRequest request);

    ApiResponse<PermissionResponse> createUserPermission(PermissionCreateRequest request);
    ApiResponse<Integer> deleteUserPermission(PermissionQueryRequest request);
    ApiResponse<List<PermissionResponse>> getUserPermission(PermissionQueryRequest request);

    ApiResponse<StatResponse> createUserStat(StatCreateRequest request);
    ApiResponse<Integer> deleteUserStat(StatQueryRequest request);
    ApiResponse<List<StatResponse>> getUserStat(StatQueryRequest request);

    ApiResponse<LogResponse> createUserLog(LogCreateRequest request);
    ApiResponse<Integer> deleteUserLog(LogQueryRequest request);
    ApiResponse<List<LogResponse>> getUserLog(LogQueryRequest request);

}