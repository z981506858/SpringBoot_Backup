package com.zz.springboot.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SendMessageFanoutController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendFanout")
    @ResponseBody
    public String sendFanout(){
        String mid = String.valueOf(UUID.randomUUID());
        String msg = "this is a test of FanoutExchange";
        String ct = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,String> map = new HashMap<>();
        map.put("mid",mid);
        map.put("msg",msg);
        map.put("ct",ct);
        rabbitTemplate.convertAndSend("fanoutExchange",null,map);
        return "ok";
    }
}
