package com.charon.mq_consumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author: tk
 * @create: 2019-11-01 14:13
 **/
@Component
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")
    public void recevie(TextMessage textMessage) throws JMSException {
        System.out.println("消费者监听到的消息是："+textMessage.getText());
    }

}
