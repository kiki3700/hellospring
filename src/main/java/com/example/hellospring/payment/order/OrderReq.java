package com.example.hellospring.payment.order;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * OrderReq <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/12/15 <br>
 * Time: <br>
 */
public record OrderReq(String no, BigDecimal total) {
}
