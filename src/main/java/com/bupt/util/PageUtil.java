package com.bupt.util;

import com.bupt.result.page.Filter;
import com.bupt.result.page.Pageable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class PageUtil {
    public static Map<String, Object> page(Pageable select) {
        //构造 map 以使用 beanSearcher
        Map<String, Object> where = new HashMap<>();
        //添加分页及排序条件
        where.put("page", select.getPage());
        where.put("size", select.getSize());
        where.put("sort", select.getSort());
        //TODO 排序


        //新建 list 以供后续存储查询条件并处理为 beanSearcher 可识别的形式
        List<Filter> filters = new ArrayList<>();
        //初始化 new list
        Collections.addAll(filters, new Filter[select.getFilters().size()]);
        //copy 前端 DTO 中查询 list 以供处理
        Collections.copy(filters, select.getFilters());
        //循环将查询及查询条件放入 map 交给 beanSearcher 处理
        for (Filter f : filters) {
            //判断是否携带运算符 必须携带运算符才能进行筛选

        }
        System.out.println(where);
        return where;
    }
}
