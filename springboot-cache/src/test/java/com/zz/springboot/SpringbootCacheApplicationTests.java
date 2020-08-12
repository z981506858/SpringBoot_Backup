package com.zz.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作字符串
    @Autowired
    RedisTemplate redisTemplate; //操作k-v对象


    @Test
    void contextLoads() {
        //stringRedisTemplate.opsForValue().append("msg","zz is goodBoy");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

}
