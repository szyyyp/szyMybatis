package com.bupt.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.result.page.PageResult;
import com.bupt.result.page.Pageable;
import com.bupt.util.ReflexUtil;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * 如果继承对象为多个类组成的复杂对象，则需要重写add，del,update等函数
 * @param <M>
 * @param <T>
 */
@SuppressWarnings({"all"})
public  class BaseServiceImpl<M extends BaseMapper<T>, T>
        extends ServiceImpl<M,T> {

    public PageResult<T> findPageInfo(Pageable p ){
        return ReflexUtil.findPage(this.getBaseMapper(),p);
    }

    /**
     * 对子对象进行分页查询
     * @param detailDao
     * @param page
     * @return
     * @param <Detail>
     */
    public <Detail> PageResult<Detail> findDetail(BaseMapper<Detail> detailDao, Pageable<Detail> page){
        return ReflexUtil.findPage(detailDao,page);
    }

    @Transactional
    public  boolean saveOrUpdate(T t){
        return super.saveOrUpdate(t);
    };

    @Transactional
    public boolean saveBatch(Collection<T> entityList, int batchSize){
        return super.saveBatch(entityList, batchSize);
    }

    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize){
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    public boolean updateBatchById(Collection<T> entityList, int batchSize){
        return super.updateBatchById(entityList, batchSize);
    }

    @Transactional
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Transactional
    public boolean removeByIds(Collection<?> list){
        return super.removeBatchByIds(list);
    }

    public T findById(Serializable id){
        return super.getById(id);
    }


}
