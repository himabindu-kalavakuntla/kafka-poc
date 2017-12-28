package com.kafka.kafkapoc.publisher;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaPublisherConfig {

    private static final String SSL = "SSL";

    @Value("${kafka.bootstrap.servers}")
    private String bootStrapServers;

    private Map<String, Object> publisherConfiguration() {
        Map<String, Object> configuationMap = new HashMap<>();
        configuationMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        configuationMap.put(ProducerConfig.RETRIES_CONFIG, 0);
        configuationMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configuationMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return configuationMap;
    }

    @Bean
    public Producer<String, String> kafkaProducer() {

        return new KafkaProducer<>(publisherConfiguration());
    }
}
