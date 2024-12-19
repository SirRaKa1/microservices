package ru.rakalus.microservice_auth.service;

import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.rakalus.microservice_auth.domain.model.User;
import ru.rakalus.microservice_auth.exception.UserExistsException;
import ru.rakalus.microservice_auth.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    
    @Override
    public User save(User user) {
    
        User temp_u = userRepository.save(
                User.builder()
                        .id(UUID.randomUUID())
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .build());
        return temp_u;
    }

    @Override
    public User create(User user) throws Exception {


        if (userRepository.exists(Example.of(User.builder().login(user.getLogin()).build()))) {
            throw new UserExistsException(HttpStatus.CONFLICT);
        }


        return save(user);


    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findOne(Example.of(User.builder().login(login).build())).orElse(null);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByLogin;
    }

    @Override
    public User getCurrentUser() {
        return getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
