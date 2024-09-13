package ru.rakalus.ms.microservice1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1/ping")
public class PingController {

    @GetMapping
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
