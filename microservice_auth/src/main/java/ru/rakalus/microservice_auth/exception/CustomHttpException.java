package ru.rakalus.microservice_auth.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomHttpException extends Exception{
    private final HttpStatus httpStatus;

    public CustomHttpException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
