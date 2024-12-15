package com.example.hellospring.payment.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.stream.Collectors;

/**
 * Project: hello-spring <br>
 * SimpleApiExecutor <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/03 <br>
 * Time: <br>
 */
public class SimpleApiExecutor implements ApiExecutor {

    @Override
    public String execute(URI uri) throws IOException {
        HttpURLConnection connection;
        connection = (HttpURLConnection) uri.toURL().openConnection();
        try (var br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            return br.lines().collect(Collectors.joining());
        }
    }
}
