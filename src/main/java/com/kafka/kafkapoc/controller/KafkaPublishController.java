package com.kafka.kafkapoc.controller;

import com.kafka.kafkapoc.domain.UserEnrollment;
import com.kafka.kafkapoc.service.KafkaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPublishController {

    private final KafkaProcessService kafkaProcessService;

    @Autowired
    public KafkaPublishController(KafkaProcessService kafkaProcessService) {
        this.kafkaProcessService = kafkaProcessService;
    }

    @PostMapping("/test-kafka")
    public String sendMessageToKafka(@RequestBody UserEnrollment userEnrollment) {

        System.out.println("request::" + userEnrollment);

        String response = kafkaProcessService.sendKafkaMessage(userEnrollment);
        System.out.println("response::" + response);
        return response;
    }

}
