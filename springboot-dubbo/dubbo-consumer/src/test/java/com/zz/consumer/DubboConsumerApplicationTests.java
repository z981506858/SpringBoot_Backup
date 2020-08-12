package com.zz.consumer;

import com.zz.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboConsumerApplicationTests {
    @Autowired
    ConsumerService consumerService;

    @Test
    void contextLoads() {
        consumerService.getTicket();
    }

}
