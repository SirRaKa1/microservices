package ru.rakalus.microservice_auth.domain.dto;


import lombok.Data;

@Data
public class SignUpRequest {
    private String login;

    private String password;



}
