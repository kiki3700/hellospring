package com.example.hellospring.payment.data;

import com.example.hellospring.payment.order.Order;
import com.example.hellospring.payment.order.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Project: hello-spring <br>
 * OrderRepository <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/16 <br>
 * Time: <br>
 */


public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
