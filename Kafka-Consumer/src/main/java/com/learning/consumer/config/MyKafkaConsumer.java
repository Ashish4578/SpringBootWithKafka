package com.learning.consumer.config;

import com.learning.common.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {

    @KafkaListener(topics = "my-topic-message", groupId = "my-group-message")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "my-topic-order", groupId = "my-group-order", containerFactory = "orderKafkaListenerFactory")
    public void consumedOrder(Order order) {
        System.out.println("Received message: " + order.toString());
    }
}
