package com.bupt.util;

import com.bupt.result.page.Filter;
import com.bupt.result.page.Pageable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.*;

@Data
@AllArgsConstructor
public class PageUtil {
    public static Map<String, Object> page(Pageable select) throws IllegalAccessException {
        //构造 map 以使用 beanSearcher
        Map<String, Object> where = new HashMap<>();
        //添加分页及排序条件
        where.put("page", select.getPage());
        where.put("size", select.getSize());
        where.put("sort", select.getSort());
        /*if (select.getWorkgroupId()!=null){
            where.put("workgroupId",select.getWorkgroupId());
        }*/
        /*if (select.getStringOrder() != null) {
            select.setOrder(Pageable.Order.valueOf(select.getStringOrder()));
        }*/
        where.put("order", select.getOrder().toString());
        //新建 list 以供后续存储查询条件并处理为 beanSearcher 可识别的形式
        List<Filter> filters = new ArrayList<>();
        //初始化 new list
        Collections.addAll(filters, new Filter[select.getFilters().size()]);
        //copy 前端 DTO 中查询 list 以供处理
        Collections.copy(filters, select.getFilters());
        //循环将查询及查询条件放入 map 交给 beanSearcher 处理
        for (Filter f : filters) {
            //如果携带的运算符为 between、not between、in 则对携带的 value 数组进行处理并将处理之后的结果加入 map 集合
            if (f.getStringOperator().equals("bt") || f.getStringOperator().equals("nb") || f.getStringOperator().equals("il")) {
                //如果前端传的 value 是 list 类型才进行处理 否则不处理
                if (f.getValue() instanceof List) {
                    String property = f.getProperty();
                    //将 object 类型的 value 转换为数组类型
                    Object[] listArray = f.castList(f.getValue(), Object.class);
                    //通过 for 循环获取数组索引及数组具体值并存入 map 集合
                    for (int i = 0; i < listArray.length; i++) {
                        where.put(property + "x" + i, listArray[i]);
                    }
                    //在 map 集合中添加运算符
                    String operator = f.getProperty() + "xop";
                    f.setOperator(Filter.fromString(f.getStringOperator()));
                    String operatorValue = f.getOperator().toString();
                    where.put(operator, operatorValue);
                }
                //非以上运算符的情况下的逻辑
            } else {
                //value 不为空才进行下一步操作 否则直接跳过
                if (f.getValue() != null) {
                    //将筛选属性和值存入 map 集合
                    where.put(f.getProperty(), f.getValue());
                }
                //将对应运算符存入 map 集合
                String operator = f.getProperty() + "xop";
                f.setOperator(Filter.fromString(f.getStringOperator()));
                String operatorValue = f.getOperator().toString();
                where.put(operator, operatorValue);
            }

        }
        //2024.05.06添加实体类支持
        Class clazz = select.getT().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            if (name.equals("serialVersionUID")) {
                break;
            }
            field.setAccessible(true);
            Object value = field.get(select.getT());
            if (value != null) {
                //System.out.println(value.getClass().getName());
                if (value instanceof String) {
                    where.put(name + "xop", "ct");
                    where.put(name, value);
                }/* else if (value.getClass().getName() == "java.util.ArrayList") {
                    where.put(name + "xop", "il");
                    List<Integer> result = new ArrayList<>();
                    for (Object o : (List<?>) value) {
                        result.add(Integer.class.cast(o));
                    }
                    for (int i = 0; i < result.size(); i++) {
                        where.put(name + "x" + i, result.get(i));
                    }
                }*/ else {
                    where.put(name, value);
                }
            }
        }
        //System.out.println(where);
        return where;
    }
}

