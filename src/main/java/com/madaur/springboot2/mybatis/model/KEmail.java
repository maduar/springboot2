package com.madaur.springboot2.mybatis.model;

import lombok.ToString;

@ToString
public class KEmail {
    private Integer kId;

    private String kEmail;

    private Integer tId;

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }

    public String getkEmail() {
        return kEmail;
    }

    public void setkEmail(String kEmail) {
        this.kEmail = kEmail == null ? null : kEmail.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }
}
