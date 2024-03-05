package com.bupt.mapper;

import com.bupt.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarDao extends BaseDao<Car,Long> {

    int insert(Car car);

    int update(Car car);
}
