package com.example.springLearn.RabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.queue.jsonName}")
    private String jsonQueueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.routing.jsonKey}")
    private String jsonRoutingKey;

    //queue bean
    @Bean
    public Queue queue( ) {
        return new Queue(queueName);
    }

    @Bean
    public Queue jsonQueue( ) {
        return new Queue(jsonQueueName);
    }
    //exchange bean
    @Bean
    public TopicExchange exchange( ) {
        return new TopicExchange(exchangeName);
    }
    //binding between queue and exchange using routing key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding jsonBinding(Queue jsonQueue, TopicExchange exchange) {
        return BindingBuilder.bind(jsonQueue).to(exchange).with(jsonRoutingKey);
    }


    // ConnectionFactory, RabbitTemplate, and RabbitAdmin beans can be configured here if needed

    // method to convert message to json
    @Bean
    public MessageConverter jsonMessageConverter( ) {
        return new Jackson2JsonMessageConverter(); // Implement JSON message converter if needed
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
