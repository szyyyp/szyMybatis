package com.bupt.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.page.Pageable;
import com.bupt.util.ReflexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings({"all"})
public abstract class HeadAndDetail<HeadMapper extends BaseMapper<Head>, Head,
        DetailMapper extends BaseMapper<Detail> ,Detail>
        extends ServiceImpl<HeadMapper,Head>
{
    @Autowired
    HeadMapper headMapper;
    @Autowired
    DetailMapper detailMapper;

    public Page<Head> findHead(Pageable page,Head h){
        return ReflexUtil.findByEntity(headMapper,page,h);
    }

    public Page<Detail> findDetail(Pageable page,Detail t){
        return ReflexUtil.findByEntity(detailMapper,page,t);
    }

    @Transactional
    public abstract boolean addHead(Head h);

    @Transactional
    public boolean deleteHead(Head h){
        // todo 先删除子表数据，再删除主表

        return true;
    }
}
