package com.bupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
