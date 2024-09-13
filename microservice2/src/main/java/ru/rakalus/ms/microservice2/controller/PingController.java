package ru.rakalus.ms.microservice2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms2/ping")
public class PingController {

    @GetMapping
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("Sup dude", HttpStatus.OK);
    }
}