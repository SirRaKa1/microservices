package ru.rakalus.microservice_auth.service;

import org.springframework.security.core.userdetails.UserDetails;

import ru.rakalus.microservice_auth.domain.model.User;

public interface JwtService {
    
    public String generateToken(User user);

    public boolean isTokenValid(String token, UserDetails userDetails);
    public String extractUserLogin(String token);
}
