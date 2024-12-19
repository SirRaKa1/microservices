package ru.rakalus.ms.microservice1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.rakalus.ms.microservice1.domain.SendUser;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity getMethodName(@RequestHeader MultiValueMap<String, String> headers) {

        log.info("getting user");
        // Явно создаем новый HttpHeaders 
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.addAll(headers);
    
        // Принудительно добавляем Authorization header, если нужно
        String authHeader = headers.getFirst("authorization");
        if (authHeader != null) {
            httpHeaders.set("Authorization", authHeader);
        }
    
        // Создаем HttpEntity с явным указанием headers
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
    
        try {
            ResponseEntity<SendUser> response = restTemplate.exchange(
                "http://microservice-auth:8092/auth/get", 
                HttpMethod.GET, 
                entity, 
                SendUser.class
            );
            log.info("got user " + response.getBody().getLogin());
            return new ResponseEntity<>(response.getBody(),response.getStatusCode());
        } catch (HttpClientErrorException e) {
            log.error("Detailed error: Status {}, Body: {}", 
                e.getStatusCode(), 
                e.getResponseBodyAsString(), 
                e
            );
            return ResponseEntity
                .status(e.getStatusCode())
                .body(e.getResponseBodyAsString());
        }
        catch (Exception e){
            throw e;
        }
    }
    
}
