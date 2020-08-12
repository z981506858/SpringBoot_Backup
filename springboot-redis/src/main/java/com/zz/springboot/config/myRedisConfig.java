package com.zz.springboot.config;

import com.zz.springboot.bean.EmpBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class myRedisConfig {
    @Bean
    public RedisTemplate<Object, EmpBean> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, EmpBean> template = new RedisTemplate<Object, EmpBean>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<EmpBean> ser = new Jackson2JsonRedisSerializer<EmpBean>(EmpBean.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}
