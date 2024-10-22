package com.example.hellospring.payment.exrate;

import com.example.hellospring.payment.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * SimpleExRatePaymentService <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/01 <br>
 * Time: <br>
 */
public class SimpleExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalArgumentException("지원하지 않는 통화입니다.");
    }
}
