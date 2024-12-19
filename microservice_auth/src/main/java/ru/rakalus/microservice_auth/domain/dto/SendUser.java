package ru.rakalus.microservice_auth.domain.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendUser {
    UUID id;
    String login;
}
