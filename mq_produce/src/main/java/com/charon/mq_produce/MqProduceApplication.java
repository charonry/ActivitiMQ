package com.charon.mq_produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqProduceApplication.class, args);
    }

}
