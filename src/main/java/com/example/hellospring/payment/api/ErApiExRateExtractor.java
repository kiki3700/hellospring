package com.example.hellospring.payment.api;

import com.example.hellospring.payment.exrate.ExRateDate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * ErApiExRateExtractor <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/03 <br>
 * Time: <br>
 */
public class ErApiExRateExtractor implements ExRateExtractor{
    @Override
    public BigDecimal extract(String response) throws JsonProcessingException {
        ObjectMapper mapper= new ObjectMapper();
        ExRateDate exRateDate = mapper.readValue(response, ExRateDate.class);
        return exRateDate.rates().get("KRW");
    }
}
