package com.bupt.mapper;

import com.alibaba.fastjson2.JSON;
import com.bupt.pojo.Performance;
import com.bupt.pojoTest.Car;
import com.bupt.result.HttpResult;
import com.bupt.result.HttpResultCodeEnum;
import com.bupt.result.page.*;
import com.bupt.util.PageUtil;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class BeanSearcherTest {
    @Resource
    BeanSearcher beanSearcher;

    @Test
    public void test1() throws IllegalAccessException {
        Pageable<Performance> pageable = new Pageable<>();
        Filter filter = new Filter();
        List<Filter> filters = new ArrayList<>();
        List list = new ArrayList();
        Performance p =new Performance();
        p.setClassId(86);
        list.add(0,1);
        list.add(1,2);
        filter.setProperty("score");
        filter.setOperator(Filter.Operator.il);
        filter.setValue(list);
        filters.add(filter);
        pageable.setOrder("asc");
        pageable.setPage(1);
        pageable.setSize(5);
        pageable.setFilters(filters);
        pageable.setT(p);
        System.out.println(pageable);
        System.out.println("#################");
        Map<String, Object> where = PageUtil.page(pageable);
        System.out.println(where);
        System.out.println("###################");
        SearchResult<Performance> search = beanSearcher.search(Performance.class, where);
        System.out.println(search);
        System.out.println("---------------------------------------------");
        System.out.println(JSON.toJSON(HttpResult.of(HttpResultCodeEnum.SUCCESS,new PageResult<Performance>().pageResult(where, search, pageable))));
    }

    @Test
    public void test2() throws IllegalAccessException {
        Pageable<Car> pageable = new Pageable<>();
        Filter filter = new Filter();
        List<Filter> filters = new ArrayList<>();
        List list = new ArrayList();
        Car s =new Car();

        list.add(0,3387);
        list.add(1,3402);
        filter.setProperty("id");
        filter.setOperator(Filter.Operator.bt);
        filter.setValue(list);
        filters.add(filter);
        pageable.setOrder("asc");
        pageable.setPage(1);
        pageable.setSize(5);
        pageable.setFilters(filters);
        pageable.setT(s);
        System.out.println(pageable);
        System.out.println("#################");
        Map<String, Object> where = PageUtil.page(pageable);
        System.out.println(where);
        System.out.println("###################");
        SearchResult<Car> search = beanSearcher.search(Car.class, where);
        System.out.println(search);
        System.out.println("---------------------------------------------");
        PageResult  v = new PageResult<Car>();
        v = v.pageResult(where, search, pageable);
        System.out.println(JSON.toJSON(HttpResult.of(HttpResultCodeEnum.SUCCESS,v)));
    }
}
