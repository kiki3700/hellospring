package com.example.hellospring.payment.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Project: hello-spring <br>
 * HttpClientExecutor <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/04 <br>
 * Time: <br>
 */
public class HttpClientExecutor implements ApiExecutor {
    public String execute(URI uri) throws IOException {
        var request = HttpRequest.newBuilder().uri(uri).GET().build();
        try (HttpClient client = HttpClient.newBuilder().build()) {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}