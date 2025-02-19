package dev.ole.octopus;

import dev.ole.octopus.client.ApiClient;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;

public class OctopusApiClient implements ApiClient {

    @Override
    public String getBaseUrl() {
        return "";
    }

    @Override
    public URI getURI(String suffix) {
        return null;
    }

    @Override
    public <T, S> T post(S request, URI route, Type type) {
        return null;
    }

    @Override
    public <T> HttpRequest newRequest(T request, URI route) {
        return null;
    }
}
