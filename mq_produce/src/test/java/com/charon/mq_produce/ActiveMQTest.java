package com.charon.mq_produce;

import com.charon.mq_produce.produce.Queue_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = MqProduceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActiveMQTest {

    @Resource
    private Queue_Produce queueProduce;

    @Test
    public void sendTest() throws Exception{
        queueProduce.proMsg();
    }

}
