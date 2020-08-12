package com.zz.springboot.mapper;

import com.zz.springboot.bean.EmpBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    EmpBean getEmpById(Integer id);
}
