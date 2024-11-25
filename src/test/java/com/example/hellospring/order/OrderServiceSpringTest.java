package com.example.hellospring.order;

import com.example.hellospring.payment.OrderConfig;
import com.example.hellospring.payment.order.Order;
import com.example.hellospring.payment.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * OrderServiceSpringTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/25 <br>
 * Time: <br>
 */
@SpringBootTest
@ContextConfiguration(classes = OrderConfig.class)
public class OrderServiceSpringTest {
    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        var order = orderService.createOrder("1", BigDecimal.TEN);
        Assertions.assertThat(order.getId()).isGreaterThan(0L);
    }
}
