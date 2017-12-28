package com.kafka.kafkapoc.subscriber;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaSubscriberConfig {

    @Value("${kafka.bootstrap.servers}")
    private String pubSubServers;

    @Value("${kafka.consumer.topic}")
    private String topic;

    @Value("${kafka.consumer.group.id.config}")
    private String consumerGroupIdConfig;

    @Value("${kafka.consumer.max.poll.interval}")
    private Integer maxPollIntervalMs;

    @Value("${kafka.consumer.session.timeout}")
    private Integer sessionTimeOutMs;

    private Map<String, Object> consumerConfigs() {
        Map<String, Object> confMap = new HashMap<>();
        confMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, pubSubServers);
        confMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        confMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        confMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        confMap.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupIdConfig);
        confMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
       // confMap.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollIntervalMs);
       // confMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeOutMs);
        confMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        confMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OffsetResetStrategy.EARLIEST.name().toLowerCase());

        return confMap;
    }

    @Bean
    public Consumer<String, String> kafkaConsumer() {
        Consumer<String, String> consumer = new KafkaConsumer<>(consumerConfigs());
        consumer.subscribe(Collections.singletonList(topic));
        return consumer;
    }

}
