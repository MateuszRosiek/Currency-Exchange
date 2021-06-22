package com.currencyexchange.model;

import java.util.List;

public class Currency {
    private char table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public Currency(char table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public char getTable() {
        return table;
    }

    public void setTable(char table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRate(List<Rate> rates) {
        this.rates = rates;
    }
}
