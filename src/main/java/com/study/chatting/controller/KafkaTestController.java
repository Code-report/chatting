package com.study.chatting.controller;

import com.study.chatting.model.ProducerDto;
import com.study.chatting.model.Producers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaTestController {
    private final Producers producers;

    @GetMapping("/kafka")
    public void kafkaTest(@ModelAttribute ProducerDto producerDto){
        producers.sendMessage(producerDto.getTopic(), producerDto.getMessage());
    }
}
