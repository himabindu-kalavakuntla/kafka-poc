package com.kafka.kafkapoc.controller;

import com.kafka.kafkapoc.domain.UserEnrollment;
import com.kafka.kafkapoc.service.KafkaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KafkaPublishController {

    private final KafkaProcessService kafkaProcessService;

    @Autowired
    public KafkaPublishController(KafkaProcessService kafkaProcessService) {
        this.kafkaProcessService = kafkaProcessService;
    }

    @PostMapping("/create-user")
    public String sendMessageToKafka(@RequestBody UserEnrollment userEnrollment) {

        System.out.println("request::" + userEnrollment);

        String response = kafkaProcessService.sendKafkaMessage(userEnrollment);
        System.out.println("response::" + response);
        return response;
    }

    @GetMapping("/get-employees")
    public List<UserEnrollment> getAllEmployees() {

        return kafkaProcessService.getAllEmployees();

    }

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Kafka Example");
        return "index";
    }

}
