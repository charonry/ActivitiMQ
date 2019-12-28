package com.charon.mq_produce.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component

public class Queue_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void proMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"******"+ UUID.randomUUID().toString().substring(0,6));
    }

    //间隔三秒钟定投
    @Scheduled(fixedDelay = 3000)
    public void proMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"****** Scheduled："+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("***********MsgScheduled send ok");
    }
}
