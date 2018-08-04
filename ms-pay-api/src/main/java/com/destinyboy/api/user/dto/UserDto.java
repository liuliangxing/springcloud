package com.destinyboy.api.user.dto;


import com.destinyboy.api.user.groups.EditUserBalanceGroup;
import com.destinyboy.api.user.groups.SaveUserGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class UserDto implements Serializable {

    @NotNull(groups = {EditUserBalanceGroup.class})
    private Long  id;

    @NotEmpty(groups = {SaveUserGroup.class})
    private String name;

    @NotNull(groups = {SaveUserGroup.class, EditUserBalanceGroup.class})
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
