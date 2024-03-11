package com.bupt.mapper;

import com.bupt.config.EasyBaseMapper;
import com.bupt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserMapper extends EasyBaseMapper<User> {

}
