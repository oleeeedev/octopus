package dev.ole.octopus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.ole.octopus.client.ApiClient;
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

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class OctopusApiClient implements ApiClient {

    private final String baseUrl;

    public OctopusApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public URI getURI(String suffix) {
        return URI.create(baseUrl + suffix);
    }

    @Override
    public <T, S> T post(S request, URI route, Type type) {
        HttpRequest httpRequest = newRequest(request, route);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), type);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> HttpRequest newRequest(T request, URI route) {
        String json = new Gson().toJson(request);
        return HttpRequest.newBuilder().uri(route).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
    }

    @Override
    public ApiResponse<AttributeResponse> createRoleAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteRoleAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getRoleAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<PermissionResponse> createRolePermission(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteRolePermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<PermissionResponse>> getRolePermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<AttributeResponse> createServerAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteServerAttribute(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getServerAttribute(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<StatResponse> createServerStat(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteServerStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<StatResponse>> getServerStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<AttributeResponse> createUserAttribute(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<AttributeResponse>> getUserAttributes(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<PermissionResponse> createUserPermission(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserPermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<PermissionResponse>> getUserPermission(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<StatResponse> createUserStat(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<StatResponse>> getUserStat(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<LogResponse> createUserLog(LogCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, LogResponse.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<Integer> deleteUserLog(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return post(request, route, responseType);
    }

    @Override
    public ApiResponse<List<LogResponse>> getUserLog(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, LogResponse.class).getType();
        return post(request, route, responseType);
    }
}