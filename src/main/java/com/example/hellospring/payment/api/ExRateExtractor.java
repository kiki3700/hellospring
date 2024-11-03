package com.example.hellospring.payment.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * ExRateExtractor <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/03 <br>
 * Time: <br>
 */
public interface ExRateExtractor {
    BigDecimal extract(String response) throws JsonProcessingException;
}

