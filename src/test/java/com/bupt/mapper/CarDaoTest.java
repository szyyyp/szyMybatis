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

    @Test
    public void insertCar(){
        Car car = new Car(null,"111","丰田",150.00,"新能源","2023-03-06");
        int i = carDao.insert(car);
        System.out.println(car.getId());
    }
}