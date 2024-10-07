package com.example.hellospring;

import com.example.hellospring.payment.payment.ExRateProvider;
import com.example.hellospring.payment.payment.ExRateProviderStub;
import com.example.hellospring.payment.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static java.math.BigDecimal.valueOf;

/**
 * Project: hello-spring <br>
 * TestObjectFactory <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/10/03 <br>
 * Time: <br>
 */
@Configuration
public class TestPaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(valueOf(1_000));
    }

    @Bean
    public Clock clock(){return Clock.fixed(Instant.now(), ZoneId.systemDefault());}
}
