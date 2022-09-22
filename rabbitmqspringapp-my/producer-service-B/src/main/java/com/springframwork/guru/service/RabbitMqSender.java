package com.springframwork.guru.service;

import com.springframwork.guru.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkeyC}")
    private String routingkey;

    public void send(User user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);

    }

}

    // We will create a service class named RabbitMQSender to send messages to RabbitMQ.
    // This class defines two properties: exchange and routingkey. 
    // The exchange property defines the RabbitMQ exchange that is 
    // responsible for routing the messages to different queues. 
    // Then the routingkey property defines how to route 
    // the messages to the queue depending on the exchange type.

    // Next, line 5-7 autowires an rabbitTemplate object of the RabbitTemplate class. 
    // The RabbitTemplate class allows sending and receiving messages with RabbitMQ.

    // Then, line 10-14  sets the exchange and routingkey fields 
    // with the values from the application.yml file.

    // Finally, line 16-17 defines the send() method that calls the convertAndSend() 
    // method of the RabbitTemplate class and sets exchange routing user to it. 
    // This convertAndSend() method then pushes the message 
    // to exchange with the specified routingkey