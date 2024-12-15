package com.example.hellospring;

import com.example.hellospring.payment.Sort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Project: hello-spring <br>
 * SortTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/09/11 <br>
 * Time: <br>
 */
public class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
    }

    @Test
    void sort() {
        var list = sort.sortByLength(Arrays.asList("aa", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {
        var list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
