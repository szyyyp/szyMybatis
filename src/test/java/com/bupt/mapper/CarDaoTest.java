package com.bupt.mapper;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.bupt.pojo.Car;
import com.bupt.pojo.TStudent;
import com.bupt.result.page.Pageable;
import com.bupt.service.CarServiceImpl;
import com.bupt.service.UserService;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.operator.Contain;
import com.ejlchina.searcher.operator.NotEmpty;
import com.ejlchina.searcher.util.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 直接使用junit的单元测试方法
 * 建议使用
 */
@SpringBootTest
class CarDaoTest  {
    @Autowired
    CarDao carDao;
    @Autowired
    BeanSearcher beanSearcher;
    @Autowired
    CarServiceImpl carService;
    @Autowired
    UserService userService;

    @Test
    public void findAll() {
        LambdaQueryWrapper<Car> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Car::getBrand,"丰田");
        List<Car> lst = carDao.selectList(queryWrapper);
        System.out.println(lst);
    }

    @Test
    public void testMethod(){
        QueryWrapper<Car> wrapper=new QueryWrapper<>();
        Car car = new Car();
        car.setBrand("1234");
        wrapper.eq(car.getBrand()!=null
        , "brand","丰田");
        List<Car> lst = carDao.selectList(wrapper);
        System.out.println(lst);
    }


    @Test
    public void insertCar(){
        Car car = new Car(null,"221","丰田",150.00,"新能源","2023-03-06");
        int i = carDao.insert(car);

        System.out.println(car.getId());
    }

    @Test
    void getSearch(){
        Map<String, Object> params = MapUtils.builder()
                .page(0,10)                                    //第1页10条
                .orderBy(TStudent::getAge).desc()               // age 字段，降序
                .onlySelect(TStudent::getName, TStudent::getAge)  //只查询 age 与 name 字段
                .field(TStudent::getName).op("小红")             //查询 name 等于 小红 的用户
                .field(TStudent::getName).op(NotEmpty.class)    //查询 name 不为空的用户
                .field(TStudent::getName, "小红").op(Contain.class)    // 查询 name 中包含字符串 小红 的用户
                .build();
        SearchResult<TStudent> search = beanSearcher.search(TStudent.class, params);
        List<TStudent> dataList = search.getDataList();        //获取数据列表
        Number totalCount = search.getTotalCount();           //获取数据总数
        System.out.println(dataList);
        System.out.println(totalCount);
    }

    @Test
    void testSaveBatch(){
        carService.saveBatch();
    }


    @Test
    void testEntityFind(){
        Car car = new Car();
        car.setBrand("丰田");
        car.setCarNum("111");
        Pageable pageable = new Pageable();
        List<OrderItem> orders = new ArrayList<>();

        orders.add(OrderItem.desc("guide_price"));
        pageable.setOrders(orders);
        System.out.println(JSON.toJSON(carService.findPageInfo(car,pageable)));
    }
    @Test
    void testUerMapper(){
        userService.InsertUsers();
    }

}