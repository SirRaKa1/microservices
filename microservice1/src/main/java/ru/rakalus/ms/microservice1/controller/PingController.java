package ru.rakalus.ms.microservice1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public ResponseEntity<String> ping(){
        log.info("yay");
        System.out.println("yay");
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
