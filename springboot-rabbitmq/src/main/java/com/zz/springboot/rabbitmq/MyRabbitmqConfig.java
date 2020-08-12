package com.zz.springboot.rabbitmq;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

/**
 * 配置基本mq信息
 */
@Configuration
public class MyRabbitmqConfig {

    // 队名
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    // Direct交换机
    @Bean
    public DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,false);
    }

    // 交换机和队列进行绑定
    @Bean
    public Binding BindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }


    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }

}
