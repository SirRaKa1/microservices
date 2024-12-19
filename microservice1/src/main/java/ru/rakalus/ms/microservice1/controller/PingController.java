package ru.rakalus.ms.microservice1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ping")
public class PingController {
    private final RestTemplate restTemplate;
    @GetMapping
    public ResponseEntity<String> ping(){
        log.info("yay");
        System.out.println("yay");
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/ms")
    public ResponseEntity<String> pingOtherMicroservice(@RequestHeader MultiValueMap<String, String> headers){
        log.info("pinging microservice 2");
        HttpHeaders headers1 = new HttpHeaders(headers);
        

        HttpEntity<String> entity = new HttpEntity<>(headers1);
        System.out.println(headers1);
        return restTemplate.exchange("http://microservice2:8091/ms2/ping/other",HttpMethod.GET,entity,String.class);
        
    }
}
