package com.example.hellospring.order;

import com.example.hellospring.payment.OrderConfig;
import com.example.hellospring.payment.order.Order;
import com.example.hellospring.payment.order.OrderReq;
import com.example.hellospring.payment.order.OrderService;
import com.example.hellospring.payment.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    @Autowired
    DataSource dataSource;

    @Test
    void createOrder() {
        var order = orderService.createOrder("1", BigDecimal.TEN);
        assertThat(order.getId()).isGreaterThan(0L);
    }

    @Test
    void createOrders() {
        List<OrderReq> orderReqs = List.of(new OrderReq("123", BigDecimal.ONE), new OrderReq("124", BigDecimal.ONE));
        List<Order> orders = orderService.createOrders(orderReqs);
        assertThat(orders).hasSize(2);
        orders.forEach(order -> {
            assertThat(order.getId()).isGreaterThan(0L);
        });
    }

    @Test
    void createDuplicatedOrders() {
        List<OrderReq> orderReqs = List.of(new OrderReq("123", BigDecimal.ONE), new OrderReq("123", BigDecimal.ONE));
        assertThatThrownBy(() -> orderService.createOrders(orderReqs)).isInstanceOf(DataIntegrityViolationException.class);
        JdbcClient client = JdbcClient.create(dataSource);
        var count = client.sql("select count(*) from orders where no = '123'").query(Long.class).single();
        assertThat(count).isEqualTo(0);
    }
}
