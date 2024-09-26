package ru.rakalus.ms.microservice2.controller;


import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    RabbitTemplate template;
    Logger logger = LogManager.getLogger(RabbitMQController.class);

    @PostMapping
    public ResponseEntity<String> ping(){
        template.convertAndSend("queue2","Hello from microservice 2");
        return new ResponseEntity<>("Message was sent", HttpStatus.OK);
    }


}
