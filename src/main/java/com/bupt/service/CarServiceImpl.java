package com.bupt.service;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;
import com.bupt.mapper.CarDao;
import com.bupt.pojo.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl extends BaseServiceImpl<CarDao,Car>  {
    public CarServiceImpl() {
        super();
    }

    public void saveBatch() {
        long stime = System.currentTimeMillis(); // 统计开始时间
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Car car = new Car();
            car.setCarNum("test:" + i);
            car.setBrand("123456");
            list.add(car);

        }
        // 批量插入
        this.saveBatch(list);

        long etime = System.currentTimeMillis(); // 统计结束时间
        System.out.println("执行时间：" + (etime - stime));
    }


}
