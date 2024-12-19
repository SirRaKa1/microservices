package ru.rakalus.microservice_auth.exception;

import org.springframework.http.HttpStatus;

public class SignInException extends CustomHttpException {
    public SignInException(HttpStatus httpStatus) {
        super("Неправильный логин и/или пароль", httpStatus);
    }
}
