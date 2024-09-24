package com.example.hellospring.payment.payment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Project: hello-spring <br>
 * PaymentServiceTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/24 <br>
 * Time: <br>
 */
class PaymentServiceTest {

    @Test
    void prepare() throws IOException {
        testPayment(BigDecimal.valueOf(10), BigDecimal.valueOf(100));
        testPayment(BigDecimal.valueOf(300), BigDecimal.valueOf(3_000));
        testPayment(BigDecimal.valueOf(5_000), BigDecimal.valueOf(50_000));
    }

    private static void testPayment(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
        ExRateProviderStub exRateProviderStub = new ExRateProviderStub(exRate);
        PaymentService paymentService = new PaymentService(exRateProviderStub);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        // 원화환산 금액 게산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
        // 원화환산 금액의 유효시간 계산
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }
}