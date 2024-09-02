package com.example.hellospring.payment;

/**
 * Project: hello-spring <br>
 * ObjectFractory <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/02 <br>
 * Time: <br>
 */
public class ObjectFactory {
    public PaymentService paymentService(){
        return new PaymentService(exRateProvider());
    }

    public ExRateProvider exRateProvider(){
        return new WebApiExRateProvider();

    }
}
