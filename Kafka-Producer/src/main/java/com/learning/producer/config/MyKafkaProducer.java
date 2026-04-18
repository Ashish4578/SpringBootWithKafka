package com.learning.producer.config;


import com.learning.common.model.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class MyKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Order> kafkaTemplateOrder;

    public void sendMessage(String message) {
        System.out.println("Sending message to Consumer " + message);
        kafkaTemplate.send("my-topic-message", message);
    }

    public void sendOrder(Order order) {
        System.out.println("Sending Order to Consumer " + order);
        kafkaTemplateOrder.send("my-topic-order", order);
    }
}
