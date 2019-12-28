package com.charon.mq_topic_produce.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @description:
 * @author: tk
 * @create: 2019-11-01 14:41
 **/
@Component
public class Topic_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;


    //间隔三秒钟定投
    @Scheduled(fixedDelay = 3000)
    public void proMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(topic,"主题消息："+ UUID.randomUUID().toString().substring(0,6));
    }
}
