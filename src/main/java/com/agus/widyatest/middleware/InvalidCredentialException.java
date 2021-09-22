package com.agus.widyatest.middleware;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidCredentialException extends Throwable {
    private int code;
    private String message;

    public InvalidCredentialException(int code, String message){
        super();
        this.code = code;
        this.message = message;
    }
}
