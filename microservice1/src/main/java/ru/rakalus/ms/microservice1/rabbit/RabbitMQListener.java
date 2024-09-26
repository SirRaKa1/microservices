package ru.rakalus.ms.microservice1.rabbit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@EnableRabbit
@Component
public class RabbitMQListener {

    Logger logger = LogManager.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "queue2")
    public void processQueue1(String message) {
        logger.info("Received from queue 2: {}", message);
    }

}
