package com.example.springLearn.SpringStructure.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class MyCustomException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -23445L;
    private String message;
    private HttpStatus status;

    public MyCustomException(){

    }

    public MyCustomException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public MyCustomException(String message, String message1, HttpStatus status) {
        super(message);
        this.message = message1;
        this.status = status;
    }

    public MyCustomException(String message, Throwable cause, String message1, HttpStatus status) {
        super(message, cause);
        this.message = message1;
        this.status = status;
    }

    public MyCustomException(Throwable cause, String message, HttpStatus status) {
        super(cause);
        this.message = message;
        this.status = status;
    }

    public MyCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.status = status;
    }



}
