package com.charon.mq_topic_produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqTopicProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqTopicProduceApplication.class, args);
    }

}
