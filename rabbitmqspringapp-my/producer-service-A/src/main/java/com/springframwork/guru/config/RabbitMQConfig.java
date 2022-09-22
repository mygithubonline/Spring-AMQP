package com.springframwork.guru.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queueA}")
    private String queue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkeyA}")
    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Bean
    Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.directExchange(exchange).durable(true).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(myExchange())
                .with(routingKey)
                .noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}


//  let’s start by writing a configuration class that retrieves values set 
//  in the application.yml file and then configures a message listener, 
//  declare the queue, exchange, and then binds them together.

//  This code defines six properties: queue, exchange routingKey, username, password and host. 
//  It  also uses the @Value annotation to read the values from the application.yml file.

// This code also creates a Queue bean that is durable.

// In this code,  line 27-29 creates an ExchangeBuilder bean to send a message to the queue 
// whose binding key matches the routing key of the message.

// Line 32-38 then creates a Binding bean by binding the queue, exchange and routingkey.

// Next, line 41-46 creates a CashingConnectionFactory bean of type ConnectionFactory 
// initialized with localhost, username, and password.

// Then line 49-51 creates a Jackson2JsonMessageConverter bean of type MeaasgeConverter to send 
// the message in the JSON format.

// Finally, line 54-58 creates a RabbitTemplate bean initialized with ConnectionFactory. 
// It then calls the setMessageConverter() method 
// and sets JsonMessageConverter() to set the MessageConverter.

