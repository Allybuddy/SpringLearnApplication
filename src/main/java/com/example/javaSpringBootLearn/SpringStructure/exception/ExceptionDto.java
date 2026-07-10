package com.example.javaSpringBootLearn.SpringStructure.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ExceptionDto {

    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public ExceptionDto(){};

    public ExceptionDto(String errorCode, String errorMessage, HttpStatus httpStatus){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.httpStatus=httpStatus;
    };


}
