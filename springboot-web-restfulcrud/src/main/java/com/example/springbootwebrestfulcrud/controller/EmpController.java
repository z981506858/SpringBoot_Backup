package com.example.springbootwebrestfulcrud.controller;

import com.example.springbootwebrestfulcrud.dao.DepartmentDao;
import com.example.springbootwebrestfulcrud.dao.EmployeeDao;
import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //跳转员工信息页面
    @GetMapping("/emps")
    public String toEmpList(Model model){
        //查询所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //跳转到员工添加页面
    @GetMapping("/emp")
    public String toAdd(Model model){
        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工信息
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的员工信息："+employee);
        employeeDao.save(employee);
        /**
         * redirect:重定向
         * forward:转发
         */
        return "redirect:/emps";
    }

    //跳转到修改页面
    //@PathVariable ==> 路径变量
    @GetMapping("/emp/{id}")
    public String toEditpage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //修改员工信息
    @PutMapping("/emp")
    public String updataEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @PostMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
