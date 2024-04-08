package com.bupt.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.page.Pageable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ReflexUtil {

    /**
     * 提供对任意实体类的分页查询
     * @param dao (or mapper)
     * @param page
     * @param t  entity
     * @return 实体 t 的分页查询结果
     * @param <T>
     */
    public static <T> Page<T> findByEntity(BaseMapper<T> dao, Pageable page, T t){
        QueryWrapper<T> query = getWrapper(t);
        Page<T> p = new Page<>();
        p.setCurrent(page.getPage()).setSize(page.getRows());
        dao.selectPage(p,query);
        return p;

    }

    public static Object getFieldValueByName(String fieldName, Object o) {
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

    public static List<Field> getAllField(Class<?> class1){
        List<Field> list= new ArrayList<>();
        while (class1!= Object.class){
            list.addAll(Arrays.stream(class1.getDeclaredFields()).toList());
            //获取父类
            class1=class1.getSuperclass();
        }
        return list;
    }

    private static <T> String lN(SFunction<T, ?> func) {
        LambdaMeta lambdaMeta = LambdaUtils.extract(func);
        String get = lambdaMeta.getImplMethodName().replace("get", "");
        get = get.substring(0, 1).toLowerCase() + get.substring(1);
        return get;
    }

    public static <T> QueryWrapper<T> getWrapper(T t) {
        QueryWrapper<T> query = new QueryWrapper<>();
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
}
