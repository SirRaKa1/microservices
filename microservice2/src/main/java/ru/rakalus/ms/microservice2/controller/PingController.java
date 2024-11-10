package ru.rakalus.ms.microservice2.controller;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor
public class PingController {



    @GetMapping
    public ResponseEntity<String> ping(){
        log.info("yay");
        System.out.println("yay");
        return new ResponseEntity<>("Sup dude", HttpStatus.OK);
    }

    @GetMapping("/other")
    public ResponseEntity<String> pingOther(){
        log.info("hello from microservice 1");
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}