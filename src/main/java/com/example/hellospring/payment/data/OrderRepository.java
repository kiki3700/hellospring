package com.example.hellospring.payment.data;

import com.example.hellospring.payment.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

/**
 * Project: hello-spring <br>
 * OrderRepository <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/16 <br>
 * Time: <br>
 */


public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public void save(Order order) {
        entityManager.persist(order);
    }
}
