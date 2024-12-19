package ru.rakalus.ms.microservice1.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendUser{
    UUID id;
    String login;
}
