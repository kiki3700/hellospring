package com.example.hellospring.payment.payment;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * ExRateProviderStub <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/24 <br>
 * Time: <br>
 */
public class ExRateProviderStub implements ExRateProvider {
    private BigDecimal exRate;

    public ExRateProviderStub(BigDecimal exRate) {
        this.exRate = exRate;
        ;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public void setExRate(BigDecimal exRate) {
        this.exRate = exRate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        return exRate;
    }
}
