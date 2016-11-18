package com.example.bartek.currencyapp;

import java.text.DecimalFormat;

/**
 * Created by Bartek on 2016-11-15.
 */

public class Account {

    private Double amount=120.0;
    private Currency currency;

    public Account(Double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }





}
