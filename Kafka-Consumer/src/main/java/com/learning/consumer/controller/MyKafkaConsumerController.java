package com.learning.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kafka")
public class MyKafkaConsumerController {

    @GetMapping
    public String consumeMessage() {
        return "Kafka Consumer is running and listening to messages...";
    }
}
