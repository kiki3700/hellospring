package com.example.hellospring.payment.exrate;

import com.example.hellospring.payment.api.*;
import com.example.hellospring.payment.payment.ExRateProvider;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        var url = "https://open.er-api.com/v6/latest/" + currency;
        return apiTemplate.getExRate(url);
    }
}
