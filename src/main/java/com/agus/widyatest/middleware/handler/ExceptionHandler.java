package com.agus.widyatest.middleware.handler;

import com.agus.widyatest.dto.CommonResponse;
import com.agus.widyatest.middleware.InvalidCredentialException;
import com.agus.widyatest.middleware.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<CommonResponse> resp(ProductNotFoundException e){
        return new ResponseEntity<CommonResponse>(new CommonResponse(e.getCode(), e.getMessage()), HttpStatus.OK);
    }
}
