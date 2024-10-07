package com.example.hellospring.payment.payment;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Project: hello-spring <br>
 * PaymentTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/10/07 <br>
 * Time: <br>
 */
public class PaymentTest {
    @Test
    void createPrepared() {
        var orderId = 1L;
        var currency = "USD";
        var foreignCurrencyAmount = BigDecimal.valueOf(10);
        var exRate = BigDecimal.valueOf(1);
        var clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        var payment = Payment.createPrepared(
            orderId,
            currency,
            foreignCurrencyAmount,
            exRate,
            LocalDateTime.now(clock)
        );
        var expectedConvertedAmount = foreignCurrencyAmount.multiply(exRate);
        var expectedValidUntil = LocalDateTime.now(clock).plusMinutes(30);
        assert payment.getOrderId().equals(orderId);
        assert payment.getConvertedAmount().equals(expectedConvertedAmount);
        assert payment.getValidUntil().equals(expectedValidUntil);
    }
}
