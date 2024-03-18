package com.bupt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.Method;
import java.util.List;


public class BaseServiceImpl<M extends BaseMapper<T>, T>
        extends ServiceImpl<M,T> implements IService<T> {

    public PageInfo<T> findPageInfo(T t){
        QueryWrapper<T> query = getWrapper(t);

        PageHelper.startPage(1, 10).setOrderBy("id desc");

        List<T> lts = this.list(query);
        PageInfo<T> pageInfo = new PageInfo<>(lts);

        return pageInfo;
    }
 
    private  QueryWrapper<T> getWrapper(T t) {
        QueryWrapper<T> query = new QueryWrapper();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(t.getClass());
        List<TableFieldInfo> tableFieldInfos = tableInfo.getFieldList();

        for (TableFieldInfo d : tableFieldInfos) {
            String name = d.getField().getName();
            Object value = getFieldValueByName(name, t);
            if (value != null) {
                if (d.getField().getType().toString().equalsIgnoreCase("class java.lang.string")) {
                    if (((String) value).trim().isEmpty())
                        continue;
                    query.like(d.getColumn(), value);
                } else {
                    query.eq(d.getColumn(), value);
                }
            }

        }
        return query;
    }

    private  Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            return method.invoke(o, new Object[] {});
        } catch (Exception e) {
            //   log.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * SFunction 转换为字段名
     * @param func
     * @return
     * @param <T>
     */
    private static <T> String lN(SFunction<T, ?> func) {
        SerializedLambda resolve = LambdaUtils.resolve(func);
        String get = resolve.getImplMethodName().replace("get", "");
        get = get.substring(0, 1).toLowerCase() + get.substring(1);
        return get;
    }
}
