package ru.rakalus.microservice_auth.exception;


import org.springframework.http.HttpStatus;

public class UserExistsException extends CustomHttpException {
    public UserExistsException(HttpStatus httpStatus) {
        super("Пользователь с таким логином существует",httpStatus);
    }
}
