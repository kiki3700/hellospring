package com.example.hellospring.payment.payment;

import com.example.hellospring.TestPaymentConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

import static java.lang.String.valueOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Project: hello-spring <br>
 * PaymentServiceSpringTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/10/03 <br>
 * Time: <br>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
public class PaymentServiceSpringTest {

    @Autowired
    BeanFactory beanFactory;
    @Autowired
    PaymentService paymentService;
    @Autowired
    Clock clock;

    @Test
    void testValidUntil() throws IOException {
        var payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }

    @Test
    void testPayment() throws IOException {
//        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(10_00));
        // 원화환산 금액 게산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));
        // 원화환산 금액의 유효시간 계산
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }

    @Test
    void validUntil() {

    }
}
