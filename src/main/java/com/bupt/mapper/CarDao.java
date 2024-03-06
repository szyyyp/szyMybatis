package com.bupt.mapper;

import com.bupt.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarDao extends BaseDao<Car,Long> {

    int insert(Car car);    //返回0或者，1 成功；0 失败. 要想获取插入数据记录的ID，可以通过原对象的getId()方法获取,如这里的car.getId()

    int update(Car car);
}
