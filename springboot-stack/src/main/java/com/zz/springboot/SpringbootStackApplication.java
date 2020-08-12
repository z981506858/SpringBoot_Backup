package com.zz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 开启异步功能
@SpringBootApplication
public class SpringbootStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStackApplication.class, args);
    }

}
