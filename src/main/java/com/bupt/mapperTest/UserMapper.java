package com.bupt.mapperTest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.pojoTest.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
