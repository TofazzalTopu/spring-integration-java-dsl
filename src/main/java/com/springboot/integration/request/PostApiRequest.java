package com.springboot.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostApiRequest implements Serializable{

    private String redirect;
    private Long amount;

    public PostApiRequest() {
    }

    public PostApiRequest(String redirect, Long amount) {
        this.redirect = redirect;
        this.amount = amount;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
