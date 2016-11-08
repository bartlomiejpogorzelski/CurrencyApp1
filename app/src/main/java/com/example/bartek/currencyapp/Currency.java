package com.example.bartek.currencyapp;

/**
 * Created by Bartek on 2016-11-07.
 */
public class Currency {

    private String symbol;
    private int buy;
    private int sale;

    public Currency(int buy, int sale, String symbol) {
        this.buy = buy;
        this.sale = sale;
        this.symbol = symbol;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
