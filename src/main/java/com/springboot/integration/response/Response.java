package com.springboot.integration.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private int status;
    private String message;
    private T data;
}
