package com.springboot.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse implements Serializable{
    private String item;
    private String code;

    public ApiResponse() {
    }

    public ApiResponse(String item, String code) {
        this.item = item;
        this.code = code;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
