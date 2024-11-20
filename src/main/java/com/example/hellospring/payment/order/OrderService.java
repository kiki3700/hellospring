package com.example.hellospring.payment.order;

import com.example.hellospring.payment.data.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * Service <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/20 <br>
 * Time: <br>
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final JpaTransactionManager transactionManager;

    public OrderService(OrderRepository orderRepository, JpaTransactionManager transactionManager) {
        this.orderRepository = orderRepository;
        this.transactionManager = transactionManager;
    }

    public Order createOrder(String no, BigDecimal total) {
        Order order = new Order(no, total);
        return new TransactionTemplate(transactionManager).execute(status -> {
                orderRepository.save(order);
                return order;
            }
        );
    }
}
