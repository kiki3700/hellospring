package com.example.hellospring.payment.order;

/**
 * Project: hello-spring <br>
 * OrderRepository <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/25 <br>
 * Time: <br>
 */
public interface OrderRepository {
    public void save(Order order);
}
