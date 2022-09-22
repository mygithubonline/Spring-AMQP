package com.springframwork.guru.service;

import com.springframwork.guru.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitListener(queues = "${spring.rabbitmq.queueA}")
    public void receivedMessage(User user) {

        logger.info("User Details Received is.. " + user);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}

// Let’s now write the RabbitMqReceiver class to receive messages as a Spring component.
// This class implements the RabbitListenerConfigurer interface that allows defining 
// how listener endpoints are configured. This class also overrides 
// the configureRabbitListeners() method but without any implementation.

// Then creates a receivedMessage() method that receives a User object from RabbitMQ. 
// This method is annotated with the @RabbitListener annotation that defines the queue to consume messages.
