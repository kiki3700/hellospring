package com.example.hellospring.payment;

import com.example.hellospring.payment.data.OrderRepository;
import com.example.hellospring.payment.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 * Project: hello-spring <br>
 * OrderConfig <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/20 <br>
 * Time: <br>
 */
@Configuration
@Import({DataConfig.class})
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepository();
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, JpaTransactionManager transactionManager) {
        return new OrderService(orderRepository, transactionManager);
    }
}
