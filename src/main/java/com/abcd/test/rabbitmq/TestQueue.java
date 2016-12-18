package com.abcd.test.rabbitmq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml"})

public class TestQueue{
    @Autowired
    MessageProducer mqProducer;

    final String queue_key = "queueTestKey";

    @Test
    public void send() throws IOException{
        Map<String,Object> msg = new HashMap<String,Object>();
        msg.put("data","hello,rabbmitmq!");
        mqProducer.sendMessage(queue_key,msg);
        System.in.read();
    }
}
