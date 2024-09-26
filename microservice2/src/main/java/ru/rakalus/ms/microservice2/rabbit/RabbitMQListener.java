package ru.rakalus.ms.microservice2.rabbit;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@EnableRabbit
@Component
public class RabbitMQListener {

    Logger logger = LogManager.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        logger.info("Received from queue 1: {}", message);
    }

}
