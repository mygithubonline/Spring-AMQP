package com.springframwork.guru;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerServiceApplication {

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    public static void main(String[] args) {
        SpringApplication.run(ProducerServiceApplication.class, args);
    }

/*     @Bean
    CachingConnectionFactory connectionFactory() {
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
    } */
}


// The Producer Service is a Spring Boot RESTFul service that produces messages to RabbitMQ. 
// In the Producer Service, we will create:

// A domain object
// The application.yml file
// A service
// A controller

// Finally, we will refactor the ProducerServiceApplication 
// class that contains the main() method of the application.

// This class defines three properties : host, username and passwordand 
// annotated with the @Value annotation to read the values defined in the application.yml file.

// In this code, you can see that line 17-22 creates a CashingConnectionFactory bean 
// initialized with localhost, username, and password.

// Next, line 25-27 creates a Jackson2JsonMessageConverter bean 
// of type MeaasgeConverter to send the message in the JSON format.

// Finally, line 30-34 finally creates a RabbitTemplate bean 
// initialized with ConnectionFactory. 
// It then calls the setMessageConverter() method 
// and sets JsonMessageConverter() to set the MessageConverter.

