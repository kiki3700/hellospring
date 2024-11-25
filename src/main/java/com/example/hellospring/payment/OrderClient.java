package com.example.hellospring.payment;

import com.example.hellospring.payment.order.OrderService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * DataClient <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/16 <br>
 * Time: <br>
 */
public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService orderService= beanFactory.getBean(OrderService.class);

        var order = orderService.createOrder("12", BigDecimal.valueOf(100));
        System.out.println(order);
    }
}
