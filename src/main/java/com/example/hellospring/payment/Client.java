package com.example.hellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * Client <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/01 <br>
 * Time: <br>
 */
public class Client {

    public static void main(String[] args) throws IOException {

        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
