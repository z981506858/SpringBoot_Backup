package com.zz.springboot.controller;

import com.zz.springboot.bean.EmpBean;
import com.zz.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public EmpBean getEmployee(@PathVariable("id") Integer id){
        EmpBean employee = empService.getEmp(id);
        return employee;
    }
}
