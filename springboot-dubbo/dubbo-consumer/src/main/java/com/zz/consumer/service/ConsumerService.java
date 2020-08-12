package com.zz.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zz.service.ProviderService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Reference
    ProviderService providerService;

    public void getTicket(){
        String ticket = providerService.getTicket();
        System.out.println("买到票了：" + ticket);
    }
}
