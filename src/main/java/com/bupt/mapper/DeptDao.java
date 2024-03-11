package com.bupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {
}
