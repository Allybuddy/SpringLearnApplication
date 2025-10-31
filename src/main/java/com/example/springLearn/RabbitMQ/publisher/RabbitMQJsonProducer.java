package com.example.springLearn.RabbitMQ.publisher;

import com.example.springLearn.RabbitMQ.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.jsonKey}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user) {
        log.info("Producing JSON message: {}", user);
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, user);
    }
}
