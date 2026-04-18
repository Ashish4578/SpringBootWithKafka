package com.learning.producer.controller;

import com.learning.producer.config.MyKafkaProducer;
import com.learning.common.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@AllArgsConstructor
public class MyKafkaProducerController {

    private final MyKafkaProducer myKafkaProducer;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
        myKafkaProducer.sendMessage(message);
        return "Message sent: " + message;
    }


    @PostMapping("/sendOrder")
    public String sendOrder(@RequestBody Order order) {
        myKafkaProducer.sendOrder(order);
        return "Order sent: " + order;
    }
}
