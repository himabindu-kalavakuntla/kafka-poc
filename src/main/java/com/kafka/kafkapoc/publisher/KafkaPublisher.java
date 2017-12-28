package com.kafka.kafkapoc.publisher;

import com.kafka.kafkapoc.domain.UserEnrollment;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher {

    private Producer<String, String> kafkaProducer;

    private String topic;

    @Autowired
    public KafkaPublisher(Producer<String, String> kafkaProducer,
                                    @Value("${kafka.producer.topic}") String topic) {
        this.kafkaProducer = kafkaProducer;
        this.topic = topic;
    }

    public RecordMetadata sendMessage(String userEnrollment) {
        RecordMetadata producerResponse = null;
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, userEnrollment);
            producerResponse = kafkaProducer.send(record).get();
            System.out.println("Message send to topic::" + producerResponse.topic() + "Patitions::" +
                    producerResponse.partition() + "offset::" + producerResponse.offset());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return producerResponse;
    }
}
