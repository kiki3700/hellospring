package com.example.hellospring.payment.order;

import java.math.BigDecimal;
import java.util.List;

/**
 * Project: hello-spring <br>
 * OrderService <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/12/18 <br>
 * Time: <br>
 */
public interface OrderService {
    public Order createOrder(String no, BigDecimal total);

    public List<Order> createOrders(List<OrderReq> reqs);
}
