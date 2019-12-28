package com.charon.mq_topic_consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: tk
 * @create: 2019-11-01 14:46
 **/
@Component
public class Topic_Consumer {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage){
        try {
            System.out.println("消费者订阅的主题是："+textMessage.getText());
        } catch (JMSException e) {
           logger.error("错误信息");
        }
    }
}
