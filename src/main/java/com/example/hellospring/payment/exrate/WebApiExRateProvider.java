package com.example.hellospring.payment.exrate;

import com.example.hellospring.payment.payment.ExRateProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Project: hello-spring <br>
 * WebApiExRatePaymentService <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/01 <br>
 * Time: <br>
 */
@Component
public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        var url = "https://open.er-api.com/v6/latest/" + currency;
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection connection;
        String response;
        try {
            connection = (HttpURLConnection) uri.toURL().openConnection();
            try (var br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = br.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        ExRateDate exRateDate;
        try {
            exRateDate = mapper.readValue(response, ExRateDate.class);
            return exRateDate.rates().get("KRW");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
