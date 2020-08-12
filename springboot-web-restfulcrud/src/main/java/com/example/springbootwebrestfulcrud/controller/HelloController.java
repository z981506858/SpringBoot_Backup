package com.example.springbootwebrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public String tohello(){
        return "hello world";
    }

    /*@RequestMapping({"/","/index.html"})
    public String toindex(){
        return "index";
    }*/

    @RequestMapping("success")
    public String tosuccess(Map<String,Object> map){
        map.put("hello","<h1>你好<h1>");
        map.put("user", Arrays.asList("zz","cr","wyf"));
        return "success";
    }
}
