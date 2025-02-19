package dev.ole.octopus.client;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;

public interface ApiClient {

    String getBaseUrl();

    URI getURI(String suffix);

    <T, S> T post(S request, URI route, Type type);

    <T> HttpRequest newRequest(T request, URI route);
}
