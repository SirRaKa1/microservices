package ru.rakalus.ms.microservice2.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    Logger logger = LogManager.getLogger(RabbitConfiguration.class);

    @Bean
    public Queue myQueue1() {
        return new Queue("queue1");
    }

    @Bean
    public Queue myQueue2(){
        return new Queue("queue2");
    }

}