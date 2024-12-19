package ru.rakalus.microservice_auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.rakalus.microservice_auth.domain.model.User;

public interface UserService {
    public User save(User user);

    public User create(User user) throws Exception;

    public User getByLogin(String login);

    public UserDetailsService userDetailsService();

    public User getCurrentUser();
}
