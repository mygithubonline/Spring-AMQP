package com.springframwork.guru.controller;

import com.springframwork.guru.domain.User;
import com.springframwork.guru.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {


    private RabbitMqSender rabbitMqSender;

    @Autowired
    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
        rabbitMqSender.send(user);
        return message;
    }
}

// As you can see that this code uses the uses  the @RestController annotation 
// that makes this class a RESTful web service.

// In this code, line 2 adds the @RequestMapping annotation 
// to map the HTTP requests to handler methods.

// Then, line 6-9 autowires a RabbitMqSender object to send a message to RabbitMQ.

// Next, line 12-13 creates a property named message and then annotated 
// with the @Value annotation to get the values defined in our application.yml file.

// Next, line 15-16 creates a publishUserDetails() method  
// annotated with the @PostMapping annotation 
// to map this handler method to a URL named user with the HTTP POST method.

// Finally, line 17  calls the send() method of 
// the RabbitMqSender class accepts a User object to send it to RabbitMQ.

