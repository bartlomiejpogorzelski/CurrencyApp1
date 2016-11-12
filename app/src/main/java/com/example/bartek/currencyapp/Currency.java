package com.example.bartek.currencyapp;

/**
 * Created by Bartek on 2016-11-07.
 */
public class Currency {

    private String symbol;
    private double buy;
    private double sale;



    public Currency() {}

    public Currency(double buy, double sale, String symbol) {
        this.buy = buy;
        this.sale = sale;
        this.symbol = symbol;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
