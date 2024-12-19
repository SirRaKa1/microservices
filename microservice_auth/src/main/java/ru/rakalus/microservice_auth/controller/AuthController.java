package ru.rakalus.microservice_auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.rakalus.microservice_auth.domain.dto.JwtAuthorisationResponse;
import ru.rakalus.microservice_auth.domain.dto.SignInRequest;
import ru.rakalus.microservice_auth.domain.dto.SignUpRequest;
import ru.rakalus.microservice_auth.service.AuthorizationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthController{
    private final AuthorizationService authorizationService;

    @PostMapping("/sign-up")
    public JwtAuthorisationResponse signUp(@RequestBody SignUpRequest request) throws Exception {
        JwtAuthorisationResponse signUp = authorizationService.signUp(request);
        log.info("Created user " + request.getLogin());
        return signUp;
    }


    @PostMapping("/sign-in")
    public JwtAuthorisationResponse signIn(@RequestBody SignInRequest request) throws Exception {
        JwtAuthorisationResponse signIn = authorizationService.signIn(request);
        log.info("Authorized user " + request.getLogin());
        return signIn;
    }

}
