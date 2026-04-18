package com.learning.producer.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class KafkaTopicConfig {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("my-topic-message", 1, (short) 1);
    }

    @Bean
    public NewTopic newTopic2() {
        return new NewTopic("my-topic-order", 1, (short) 1);
    }
}