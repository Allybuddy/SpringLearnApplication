package com.example.javaSpringBootLearn.SpringStructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> returnException(ValidationException exception){
        var exceptionDto = ExceptionDto.builder().errorCode(exception.getErrorCode())
                .errorMessage(exception.getErrorMessage())
                .httpStatus(exception.getHttpStatus()).build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_ACCEPTABLE);
    }
}
