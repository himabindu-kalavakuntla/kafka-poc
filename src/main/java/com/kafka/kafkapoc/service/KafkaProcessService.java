package com.kafka.kafkapoc.service;

import com.kafka.kafkapoc.domain.UserEnrollment;
import com.kafka.kafkapoc.publisher.KafkaPublisher;
import com.kafka.kafkapoc.repository.UserEnrollmentRepository;
import com.kafka.kafkapoc.subscriber.KafkaSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaProcessService {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @Autowired
    private KafkaSubscriber kafkaSubscriber;

    @Autowired
    private UserEnrollmentRepository userEnrollmentRepository;

    @Autowired
    private EmailService emailService;
    @Value("${hr.email.address}")
    private String hrEmail;

    public String sendKafkaMessage(UserEnrollment userEnrollment) {

        userEnrollmentRepository.save(userEnrollment);
        List<UserEnrollment> userEnrollmentaa = userEnrollmentRepository.findAll();
        System.out.println(" fromAddress repository size:: " + userEnrollmentaa.size());

        kafkaPublisher.sendMessage(userEnrollment.toString());
        kafkaSubscriber.run();
        String emailAddresses = userEnrollment.getEmailAddress()+","+hrEmail;


        emailService.sendMail(emailAddresses);
        return "success";
    }

    public List<UserEnrollment> getAllEmployees() {
        return userEnrollmentRepository.findAll();
    }
}
