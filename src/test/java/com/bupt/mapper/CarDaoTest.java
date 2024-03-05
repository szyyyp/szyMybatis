package com.bupt.mapper;

import com.bupt.pojo.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 直接使用junit的单元测试方法
 * 建议使用
 */
@SpringBootTest
class CarDaoTest  {
    @Autowired
    CarDao carDao;

    @Test
    public void findAll() {
        List<Car> lst = carDao.findAll();
        System.out.println(lst);
    }
}