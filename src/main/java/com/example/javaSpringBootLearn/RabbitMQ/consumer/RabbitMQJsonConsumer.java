package com.example.javaSpringBootLearn.RabbitMQ.consumer;

import com.example.javaSpringBootLearn.RabbitMQ.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.jsonName}")
    public void receiveJsonMessage(User user) {
        log.info("Consuming JSON message: {}", user);
    }
}
