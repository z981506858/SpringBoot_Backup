package com.zz.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 点对点（单播）
     */
    @Test
    void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","this is first test of mq");
        map.put("data", Arrays.asList("helloword",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","zz.news",map);
    }

    @Test
    void contextLoads() {
    }

}
