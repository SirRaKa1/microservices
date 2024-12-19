package ru.rakalus.microservice_auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.rakalus.microservice_auth.domain.dto.SendUser;
import ru.rakalus.microservice_auth.domain.model.User;
import ru.rakalus.microservice_auth.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getCurrentUser(){
        User currentUser = userService.getCurrentUser();
        log.info("Requested user " + currentUser.getLogin());
        return new ResponseEntity<SendUser>(currentUser.toSendUser(),HttpStatus.OK);
    }
}
