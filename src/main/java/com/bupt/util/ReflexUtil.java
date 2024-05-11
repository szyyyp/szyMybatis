package com.bupt.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.bupt.result.page.PageResult;
import com.bupt.result.page.Pageable;
import com.bupt.result.page.Filter;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public final class ReflexUtil {

    /**
     * 提供对任意实体类的分页查询
     *
     * @param dao  (or mapper)
     * @return 实体 t 的分页查询结果
     */
    public static <T> PageResult<T> findPage(BaseMapper<T> dao, Pageable<T> page) {
        QueryWrapper<T> query = getWrapper(page);

        PageResult<T> p = new PageResult<>();
        p.setCurrent(page.getPage()).setSize(page.getSize());
        p.setOrders(page.getOrders());

        dao.selectPage(p, query);
        return p;

    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            //   log.error(e.getMessage(),e);
            return null;
        }
    }

    private static <T> QueryWrapper<T> getWrapper(T t) {
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


    public static <T> QueryWrapper<T> getWrapper(Pageable<T> pageable) {
        QueryWrapper<T> query = new QueryWrapper<>();
        if (pageable.getT()!=null) {
             query = getWrapper(pageable.getT());
        }

        List<Filter> lstFilters = List.copyOf(pageable.getFilters());
        for (Filter filter : lstFilters) {
            //todo 前端如何传枚举值
            switch (filter.getOperator()) {
                case ct:
                    query.like(filter.getProperty(), filter.getValue());
                    break;
                case eq:
                    query.eq(filter.getProperty(), filter.getValue());
                    break;
                case ne:
                    query.ne(filter.getProperty(), filter.getValue());
                    break;
                case ge:
                    query.ge(filter.getProperty(), filter.getValue());
                    break;
                case le:
                    query.le(filter.getProperty(), filter.getValue());
                    break;
                case gt:
                    query.gt(filter.getProperty(), filter.getValue());
                    break;
                case lt:
                    query.lt(filter.getProperty(), filter.getValue());
                    break;
                case nn:
                    query.isNotNull(filter.getProperty());
                    break;
                case nl:
                    query.isNull(filter.getProperty());
                    break;
                case il:
                    List<Object> lst = Collections.singletonList(filter.getValue());
                    query.in(filter.getProperty(), lst);
                    break;
            }
        }

        return query;
    }
}
