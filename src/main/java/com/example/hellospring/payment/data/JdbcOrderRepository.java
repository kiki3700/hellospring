package com.example.hellospring.payment.data;

import com.example.hellospring.payment.order.Order;
import com.example.hellospring.payment.order.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

/**
 * Project: hello-spring <br>
 * JdbcOrderRepository <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/12/03 <br>
 * Time: <br>
 */
public class JdbcOrderRepository implements OrderRepository {
    private final JdbcClient jdbcClient;

    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcClient = JdbcClient.create(dataSource);
    }

    @PostConstruct
    void initDb() {
        jdbcClient.sql("""
            create table orders (id bigint not null, no varchar(255), total numeric(38,2), primary key (id));
            alter table if exists orders drop constraint if exists UK43egxxciqr9ncgmxbdx2avi8n;
            alter table if exists orders add constraint UK43egxxciqr9ncgmxbdx2avi8n unique (no);
            create sequence orders_SEQ start with 1 increment by 50;
            """).update();
    }

    public void save(Order order) {
        Long id = jdbcClient.sql(
            "select next value for orders_SEQ"
        ).query(Long.class).single();
        order.setId(id);
        jdbcClient.sql(
            """
                insert into orders (id, no, total) values (?, ?, ?)
                """
        ).params(order.getId(), order.getNo(), order.getTotal()).update();
    }
}
