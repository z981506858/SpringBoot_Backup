package com.zz.springboot.rabbitmq;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

/**
 * 配置主题交换机
 */
@Configuration
public class TopicRabbitmqConfig {

    @Bean
    public Queue firstQueue(){
        return new Queue("topic.man");
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("topic.woman");
    }

    @Bean
    public TopicExchange TestTopicExchange(){
        return new TopicExchange("TestTopicExchange");
    }

    @Bean
    public Binding bindingExchangeMessage1(){
        return BindingBuilder.bind(firstQueue()).to(TestTopicExchange()).with("topic.man");
    }

    @Bean
    public Binding bindingExchangeMessage2(){
        return BindingBuilder.bind(secondQueue()).to(TestTopicExchange()).with("topic.#");
    }
}
