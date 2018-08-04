package com.destinyboy.api.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDto implements Serializable {

    private Long id;
    private String orderName;
    private BigDecimal price;

    private Long userId;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
