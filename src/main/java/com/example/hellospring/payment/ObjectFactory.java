package com.example.hellospring.payment;

import com.example.hellospring.payment.exrate.CashedExRateProvider;
import com.example.hellospring.payment.payment.ExRateProvider;
import com.example.hellospring.payment.exrate.WebApiExRateProvider;
import com.example.hellospring.payment.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Project: hello-spring <br>
 * ObjectFractory <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/02 <br>
 * Time: <br>
 */
@Configuration
@ComponentScan
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider());
    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CashedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
