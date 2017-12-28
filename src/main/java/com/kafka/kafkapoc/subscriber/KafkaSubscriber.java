package com.kafka.kafkapoc.subscriber;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriber {

    private Consumer<String, String> consumer;

    public KafkaSubscriber(Consumer<String, String> consumer) {
        this.consumer = consumer;
    }

    @Scheduled(fixedDelayString = "${kafka.consumer.polling.delay}")
    public void run() {

        ConsumerRecords<String, String> consumerRecords = consumer.poll(1);

        if(consumerRecords.count() > 0){
            System.out.println("No of records fetched in consumer:{}" + consumerRecords.count() +
                    " Consumer record value " + consumerRecords.iterator().next().value());
            long startTime = System.currentTimeMillis();
            consumerRecords.partitions().forEach(
                    topicPartition -> consumerRecords.records(topicPartition).forEach(this::processTransaction));
            long timeTaken = System.currentTimeMillis() - startTime;
            System.out.println("Time to process batch :{} milliseconds" + timeTaken);
        }
    }

    private void processTransaction(ConsumerRecord<String, String> record) {
       System.out.println("Message: from [partition-{}]" + record.partition() + "offset-{}:" + record.offset());

    }
}
