package com.example.hellospring.payment.order;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Project: hello-spring <br>
 * Order <br>
 *
 * @author sunghyunlee <br>
 * Date: 2024/11/16 <br>
 * Time: <br>
 */

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String no;
    private BigDecimal total;

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", no='" + no + '\'' +
            ", total=" + total +
            '}';
    }
}
