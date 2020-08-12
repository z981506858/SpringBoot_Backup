package com.zz.springboot.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 消息推送
 */
@Controller
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    @ResponseBody
    public String sendDirectMessage(){
        int count = 0;
        String mid = String.valueOf(UUID.randomUUID());
        String msg = "this is first test for rabbitmq of Direct " + count;
        String ct = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, String> map = new HashMap<>();
        map.put("mid", mid);
        map.put("msg", msg);
        map.put("ct", ct);
        //推送消息
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);

        return "ok";
    }

    @GetMapping("/TestMessageAck")
    @ResponseBody
    public String TestMessageAck() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);
        return "ok";
    }
}
