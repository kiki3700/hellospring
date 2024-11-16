package com.example.hellospring.payment;

import com.example.hellospring.payment.data.OrderRepository;
import com.example.hellospring.payment.order.Order;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * DataClient <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/16 <br>
 * Time: <br>
 */
public class DataClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository orderRepository = beanFactory.getBean(OrderRepository.class);

        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);
        new TransactionTemplate(transactionManager).execute(
            status -> {
                // transaction
                Order order = new Order("100", BigDecimal.valueOf(10));
                // em.persist
                orderRepository.save(order);
//                Order order2 = new Order("100", BigDecimal.valueOf(10));
//                orderRepository.save(order2);

                return null;
            }
        );

    }
}
