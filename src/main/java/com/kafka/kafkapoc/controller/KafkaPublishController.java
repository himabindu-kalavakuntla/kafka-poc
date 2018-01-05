package com.kafka.kafkapoc.controller;

import com.kafka.kafkapoc.domain.UserEnrollment;
import com.kafka.kafkapoc.service.KafkaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class KafkaPublishController {

    private final KafkaProcessService kafkaProcessService;

    @Autowired
    public KafkaPublishController(KafkaProcessService kafkaProcessService) {
        this.kafkaProcessService = kafkaProcessService;
    }

    @PostMapping("/create-user")
    public ResponseEntity sendMessageToKafka(@RequestBody UserEnrollment userEnrollment) {

        System.out.println("request::" + userEnrollment);

        String response = kafkaProcessService.sendKafkaMessage(userEnrollment);
        System.out.println("response::" + response);
        return ok().build();
    }

    @GetMapping("/get-employees")
    public List<UserEnrollment> getAllEmployees() {

        return kafkaProcessService.getAllEmployees();

    }


}
