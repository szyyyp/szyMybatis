package com.bupt.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.result.page.Pageable;
import com.bupt.util.ReflexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *  所有订单类含有单头和明细的类的公共父类，主要完成：
 * <ol>
      <li>完成表单的增、删、改、分页查</li>
      <li>完成单头、明细的增、删、改、分页查</li>
      <li>只有表头，没有明细的数据不能存入数据库，会报错为：无明细数据</li>
 *  </ol>
 * @param <HeadMapper> 单头 mapper
 * @param <Head>   单头pojo
 * @param <DetailMapper> 明细 mapper
 * @param <Detail>  明细pojo
 */

@SuppressWarnings({"all"})
public abstract class BillServiceImpl<HeadMapper extends BaseMapper<Head>, Head,
        DetailMapper extends BaseMapper<Detail> ,Detail>
        extends ServiceImpl<HeadMapper,Head>
{
    @Autowired
    HeadMapper headMapper;
    @Autowired
    DetailMapper detailMapper;

    public Page<Head> findHead(Pageable<Head> page){
        return ReflexUtil.findPage(headMapper,page);
    }

    public Page<Detail> findDetail(Pageable<Detail> page){
        return ReflexUtil.findPage(detailMapper,page);
    }

    @Transactional
    public abstract boolean addBill(Head h,Detail d);

    @Transactional
    public boolean delBill(Head h){
        // todo 先删除子表数据，再删除主表

        return true;
    }
}
