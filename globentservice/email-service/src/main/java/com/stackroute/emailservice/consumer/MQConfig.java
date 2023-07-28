package com.stackroute.emailservice.consumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {
    public static final String QUEUE2 = "message_queue";
    public static final String EXCHANGE2 = "message_exchange";
    public static final String ROUTING_KEY2 = "message_routingKey";

    @Bean
    public Queue queue1() {
        return  new Queue(QUEUE2);
    }

    @Bean
    public TopicExchange exchange1() {
        return new TopicExchange(EXCHANGE2);
    }

    @Bean
    public Binding binding1(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY2);
    }

    @Bean
    public MessageConverter messageConverter1() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template1(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter1());
        return  template;
    }
}
