package com.destinyboy.api.user.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserVo implements Serializable {

    private Long id;
    private String name;
    private BigDecimal balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
