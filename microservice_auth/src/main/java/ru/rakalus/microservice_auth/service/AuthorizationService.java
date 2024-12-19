package ru.rakalus.microservice_auth.service;

import ru.rakalus.microservice_auth.domain.dto.JwtAuthorisationResponse;
import ru.rakalus.microservice_auth.domain.dto.SignInRequest;
import ru.rakalus.microservice_auth.domain.dto.SignUpRequest;

public interface AuthorizationService {
    public JwtAuthorisationResponse signUp(SignUpRequest request) throws Exception;
    public JwtAuthorisationResponse signIn(SignInRequest request) throws Exception;

}
