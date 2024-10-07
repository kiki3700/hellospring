package com.example.hellospring.learningtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Project: hello-spring <br>
 * ClockTest <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/10/03 <br>
 * Time: <br>
 */
public class ClockTest {
    // Clock을 이용해서 LocakDateTime.now?
    @Test
    void clock() {
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dt1= LocalDateTime.now(clock);
        LocalDateTime dt2= LocalDateTime.now(clock);
        Assertions.assertThat(dt2).isAfter(dt1);
    }

    // Clock을 Test 에서 사용할 때 내가 원하는 시간을 지정해서 현재 시간을 가져올 ㅅ수 있는
    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1= LocalDateTime.now(clock);
        LocalDateTime dt2= LocalDateTime.now(clock);
        LocalDateTime dt3= LocalDateTime.now(clock).plusHours(1);
        Assertions.assertThat(dt2).isEqualTo(dt1);
        Assertions.assertThat(dt3).isEqualTo(dt1.plusHours(1));
    }
}
