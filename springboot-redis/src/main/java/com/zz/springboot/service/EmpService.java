package com.zz.springboot.service;

import com.zz.springboot.bean.EmpBean;
import com.zz.springboot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    RedisTemplate<Object,EmpBean> empRedisTemplate;

    @Autowired
    EmpMapper empMapper;

    public EmpBean getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        boolean x = empRedisTemplate.hasKey("emp");
        EmpBean empList = null;
        if (x){
            System.out.println("从redis缓存中提取");
            empList = empRedisTemplate.opsForValue().get("emp");
        } else {
            System.out.println("从数据库提取");
            empList = empMapper.getEmpById(id);
            if (empList != null){
                empRedisTemplate.opsForValue().set("emp",empList);
                System.out.println("保存数据到redis");
            }
        }
        //EmpBean emp = empMapper.getEmpById(id);
        return empList;
    }
}
