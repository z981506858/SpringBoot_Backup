package com.zz.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicReceiver2 {
    @RabbitHandler
    public void process(Map testmessage){
        System.out.println("womanTopic 消费者收到消息："+testmessage.toString());
    }
}