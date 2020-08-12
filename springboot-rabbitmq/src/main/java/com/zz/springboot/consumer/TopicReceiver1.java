package com.zz.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.man")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(Map testmessage){
        System.out.println("manTopic消费者收到的消息:"+testmessage.toString());
    }
}
