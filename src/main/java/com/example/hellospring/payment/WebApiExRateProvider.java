package com.example.hellospring.payment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
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
public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateDate exRateDate = mapper.readValue(response, ExRateDate.class);
        BigDecimal exRate = exRateDate.rates().get("KRW");
        return exRate;
    }
}
