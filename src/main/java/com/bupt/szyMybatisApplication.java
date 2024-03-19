package com.bupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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