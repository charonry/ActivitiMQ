package com.charon.mq_topic_produce.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @description:
 * @author: tk
 * @create: 2019-11-01 14:35
 **/
@Component
public class ConfigBean {

    @Value("${myTopic}")
    private String topicName;

    @Bean
    public Topic topic(){
        return  new ActiveMQTopic(topicName);
    }
}
