package com.bupt;

import com.bupt.mapper.CarDao;
import com.bupt.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
public class szyMybatisApplication {

/*
    这是一种测试方法，但不建议使用
   @Autowired
    public void testGetAll(CarDao carDao){
        Car car = new Car(null,"111","奔驰",30.00,"新能源","2022-10-2");
        carDao.insert(car);
        List<Car> lst = carDao.findAll();
        System.out.println(lst);
    }*/

    public static void main(String[] args) {


        SpringApplication.run(szyMybatisApplication.class, args);
        System.out.println("Hello world!");
    }

}