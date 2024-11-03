package com.example.hellospring.payment.api;

import java.io.IOException;
import java.net.URI;

/**
 * Project: hello-spring <br>
 * ApiExecutor <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/03 <br>
 * Time: <br>
 */
public interface ApiExecutor {
    String execute(URI uri) throws IOException;
}
