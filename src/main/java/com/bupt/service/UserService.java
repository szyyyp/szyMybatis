package com.bupt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.mapper.UserMapper;
import com.bupt.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IService<User> {

    @Resource
    private UserMapper userMapper;
    public void InsertUsers(){
        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        User user;
        for(int i = 0 ;i < 10000; i++) {
            user = new User();
            user.setName("name" + i);
            user.setPassword("password" + i);
            userList.add(user);
        }
        userMapper.insertBatchSomeColumn(userList);
        long end = System.currentTimeMillis();
        System.out.println("一万条数据总耗时：" + (end-start) + "ms" );
    }
}