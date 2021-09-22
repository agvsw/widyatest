package com.agus.widyatest.middleware;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
    private int code;
    private String message;

    public ProductNotFoundException(int code, String message){
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
}
