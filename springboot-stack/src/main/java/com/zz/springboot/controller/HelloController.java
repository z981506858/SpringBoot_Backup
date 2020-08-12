package com.zz.springboot.controller;

import com.zz.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        asyncService.hello();
        return "success";
    }
}
