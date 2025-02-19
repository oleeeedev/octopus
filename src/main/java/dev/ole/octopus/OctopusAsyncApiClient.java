package dev.ole.octopus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.ole.octopus.client.AsyncApiClient;
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
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OctopusAsyncApiClient implements AsyncApiClient {

    private final String baseUrl;

    public OctopusAsyncApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public URI getURI(String suffix) {
        return URI.create(baseUrl + suffix);
    }

    @Override
    public <T, S> CompletableFuture<T> postAsync(S request, URI route, Type type) {
        HttpRequest httpRequest = newRequest(request, route);
        try (HttpClient client = HttpClient.newHttpClient()) {
            CompletableFuture<HttpResponse<String>> response = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.thenApply(body -> new Gson().fromJson(body.body(), type));
        }
    }

    @Override
    public <T> HttpRequest newRequest(T request, URI route) {
        String json = new Gson().toJson(request);
        return HttpRequest.newBuilder().uri(route).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createRoleAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteRoleAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getRoleAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<PermissionResponse>> createRolePermissionAsync(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteRolePermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<PermissionResponse>>> getRolePermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/role/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createServerAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteServerAttributeAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getServerAttributeAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<StatResponse>> createServerStatAsync(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteServerStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<StatResponse>>> getServerStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/server/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<AttributeResponse>> createUserAttributeAsync(AttributeCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<AttributeResponse>>> getUserAttributesAsync(AttributeQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/attribute/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, AttributeResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<PermissionResponse>> createUserPermissionAsync(PermissionCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserPermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<PermissionResponse>>> getUserPermissionAsync(PermissionQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/permission/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, PermissionResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<StatResponse>> createUserStatAsync(StatCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<StatResponse>>> getUserStatAsync(StatQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/stat/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, StatResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<LogResponse>> createUserLogAsync(LogCreateRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/create");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, LogResponse.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> deleteUserLogAsync(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/delete");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, Integer.class).getType();
        return postAsync(request, route, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<List<LogResponse>>> getUserLogAsync(LogQueryRequest request) {
        URI route = URI.create(getBaseUrl() + "/user/log/query");
        Type responseType = TypeToken.getParameterized(ApiResponse.class, List.class, LogResponse.class).getType();
        return postAsync(request, route, responseType);    }
}