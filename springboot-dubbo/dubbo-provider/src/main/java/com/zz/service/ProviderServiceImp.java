package com.zz.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@Component
@DubboService // 通过dubbo将服务发布出去
public class ProviderServiceImp implements ProviderService{

    @Override
    public String getTicket() {
        return "<<超级无敌帅呆>>";
    }
}
