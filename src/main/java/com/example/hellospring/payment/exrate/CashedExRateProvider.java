package com.example.hellospring.payment.exrate;

import com.example.hellospring.payment.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Project: hello-spring <br>
 * CashedExRateProvider <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/08 <br>
 * Time: <br>
 */
public class CashedExRateProvider implements ExRateProvider {
    ExRateProvider target;

    private BigDecimal cachedExRate;
    private LocalDateTime cachedExpiryTime;

    public CashedExRateProvider(ExRateProvider target) {
        this.target=   target;
    }
    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if (cachedExRate == null || cachedExpiryTime.isBefore(LocalDateTime.now())) {
            cachedExRate = target.getExRate(currency);
            cachedExpiryTime = LocalDateTime.now().plusSeconds(3);
        }
        return cachedExRate;
    }
}
