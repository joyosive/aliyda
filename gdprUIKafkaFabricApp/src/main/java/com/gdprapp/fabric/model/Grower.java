package com.gdprapp.fabric.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Grower {

    private String email;
    private Address address;
    private Long accountBalance;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
