package com.example.hellospring.payment;

import java.util.List;

/**
 * Project: hello-spring <br>
 * Sort <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/11 <br>
 * Time: <br>
 */
public class Sort {
    public List<String> sortByLength(List<String> list) {
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }
}
