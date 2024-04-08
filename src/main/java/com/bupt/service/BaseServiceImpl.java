package com.bupt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.page.Pageable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import static com.bupt.util.ReflexUtil.getWrapper;


public class BaseServiceImpl<M extends BaseMapper<T>, T>
        extends ServiceImpl<M,T> {

    public PageInfo<T> findPageInfo(T t){
        QueryWrapper<T> query = getWrapper(t);

       // PageHelper.startPage(1, 10).setOrderBy("id desc");
        PageHelper.startPage(1, 10);
        List<T> lts = this.list(query);

        return new PageInfo<>(lts);
    }

    public <Detail> Page<Detail> findDetail(BaseMapper<Detail> detailDao, Pageable page, Detail d){
        QueryWrapper<Detail> query = getWrapper(d);
        Page<Detail> p = new Page<>();
        p.setCurrent(page.getPage()).setSize(page.getRows());
        detailDao.selectPage(p,query);
        return p;

    }
}
