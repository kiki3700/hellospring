package com.example.hellospring.payment.exrate;

import com.example.hellospring.payment.payment.ExRateProvider;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Project: hello-spring <br>
 * RestTempalteExRateProvider <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/04 <br>
 * Time: <br>
 */
public class RestTemplateExRateProvider implements ExRateProvider {
    private final RestTemplate restTemplate;

    public RestTemplateExRateProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        var url = "https://open.er-api.com/v6/latest/" + currency;
        return Objects.requireNonNull(restTemplate.getForObject(url, ExRateData.class)).rates().get("KRW");
    }
}
