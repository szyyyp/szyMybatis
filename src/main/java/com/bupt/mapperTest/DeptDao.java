package com.bupt.mapperTest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.pojoTest.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {
}
