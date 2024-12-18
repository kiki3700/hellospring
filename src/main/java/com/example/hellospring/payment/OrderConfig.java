package com.example.hellospring.payment;

import com.example.hellospring.payment.data.JdbcOrderRepository;
import com.example.hellospring.payment.order.OrderRepository;
import com.example.hellospring.payment.order.OrderService;
import com.example.hellospring.payment.order.OrderServiceImpl;
import com.example.hellospring.payment.order.OrderServiceTxProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

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
    public OrderRepository orderRepository(DataSource dataSource) {
        return new JdbcOrderRepository(dataSource);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, PlatformTransactionManager transactionManager) {
        return new OrderServiceTxProxy(new OrderServiceImpl(orderRepository), transactionManager);
    }
}
