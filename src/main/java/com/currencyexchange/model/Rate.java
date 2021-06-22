package com.currencyexchange.model;

public class Rate {
    private String no;
    private String effectiveDate;
    private Float mid;

    public Rate(String no, String effectiveDate, Float mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Float getMid() {
        return mid;
    }

    public void setMid(Float mid) {
        this.mid = mid;
    }
}
