package com.example.javaSpringBootLearn.SpringStructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ValidationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -1L;
    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public ValidationException(){
    }

    public ValidationException(String errorCode, String errorMessage, HttpStatus httpStatus){
        //super(errorMessage);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.httpStatus=httpStatus;
    }
}
