package com.study.chatting.model;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumers {
    @KafkaListener(topics = "code-report")
    public void listenGroup(String message){
        System.out.println("message = " + message);
    }
}
