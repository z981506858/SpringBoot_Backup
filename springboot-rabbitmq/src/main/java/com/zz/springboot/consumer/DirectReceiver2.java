package com.zz.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消费者
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver2 {
    @RabbitHandler
    public void process(Map testmessage){
        System.out.println("第二个DirectReceiver消费者收到消息："+testmessage.toString());
    }
}
