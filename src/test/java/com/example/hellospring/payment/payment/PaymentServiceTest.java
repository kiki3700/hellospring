package com.example.hellospring.payment.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
    Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    @BeforeEach
    void setUp() throws IOException {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }
    @Test
    void prepare() throws IOException {
        testPayment(BigDecimal.valueOf(10), clock, BigDecimal.valueOf(100));
        testPayment(BigDecimal.valueOf(300), clock, BigDecimal.valueOf(3_000));
        testPayment(BigDecimal.valueOf(5_000), clock, BigDecimal.valueOf(50_000));
    }

    @Test
    void validUntil() throws IOException {
        ExRateProviderStub exRateProviderStub = new ExRateProviderStub(BigDecimal.valueOf(1_000));
        PaymentService paymentService = new PaymentService(exRateProviderStub, this.clock);
        var payment = paymentService.prepare(1L,"USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }

    public static void testPayment(BigDecimal exRate, Clock clock, BigDecimal convertedAmount) throws IOException {
        ExRateProviderStub exRateProviderStub = new ExRateProviderStub(exRate);
        PaymentService paymentService = new PaymentService(exRateProviderStub, clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        // 원화환산 금액 게산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
        // 원화환산 금액의 유효시간 계산
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }
}