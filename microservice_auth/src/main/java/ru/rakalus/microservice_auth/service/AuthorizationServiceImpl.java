package ru.rakalus.microservice_auth.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.rakalus.microservice_auth.domain.dto.JwtAuthorisationResponse;
import ru.rakalus.microservice_auth.domain.dto.SignInRequest;
import ru.rakalus.microservice_auth.domain.dto.SignUpRequest;
import ru.rakalus.microservice_auth.domain.model.User;
import ru.rakalus.microservice_auth.exception.SignInException;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthorisationResponse signUp(SignUpRequest request) throws Exception {
        
        var user = User.builder()
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();


        if (userService.create(user) != null) {
            var jwt = jwtService.generateToken(user);
            return new JwtAuthorisationResponse(jwt);
        }
        return null;
    }

    @Override
    public JwtAuthorisationResponse signIn(SignInRequest request) throws SignInException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getLogin(),
                    request.getPassword()
            ));
        }
        catch (Exception ignored){
            throw new SignInException(HttpStatus.BAD_REQUEST);
        }

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getLogin());

        var jwt = jwtService.generateToken((User) user);
        return new JwtAuthorisationResponse(jwt);
    }
}
