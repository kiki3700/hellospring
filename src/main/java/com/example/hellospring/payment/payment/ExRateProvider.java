package com.example.hellospring.payment.payment;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * ExRateProvider <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/01 <br>
 * Time: <br>
 */
public interface ExRateProvider {
    BigDecimal getExRate(String currency);
}
