package com.example.springbootwebrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String toLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Map<String,Object> map,
                          HttpSession session){
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            //登录成功，防止表单重复提交，进行重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg","密码错误");
            return "login";
        }
    }
}
