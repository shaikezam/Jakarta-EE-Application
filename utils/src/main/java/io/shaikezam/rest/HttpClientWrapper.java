package io.shaikezam.rest;

import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class HttpClientWrapper {

    public String executeGetRequest(String url, HttpResponse.BodyHandler<String> bodyHandler) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            return client.sendAsync(request, bodyHandler)
                    .thenApply(HttpResponse::body)
                    .join();
        }
    }
}
