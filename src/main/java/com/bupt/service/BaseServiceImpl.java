package com.bupt.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.result.page.PageResult;
import com.bupt.result.page.Pageable;
import com.bupt.util.ReflexUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @param <M>
 * @param <T>
 */
@SuppressWarnings({"all"})
public class BaseServiceImpl<M extends BaseMapper<T>, T>
        extends ServiceImpl<M,T> {

    @Autowired
    M dao;

    public PageResult<T> findPageInfo(T t,Pageable p ){


        return ReflexUtil.findPage(dao,p,t);
    }

    public <Detail> PageResult<Detail> findDetail(BaseMapper<Detail> detailDao, Pageable page, Detail d){

        return ReflexUtil.findPage(detailDao,page,d);
    }
}
