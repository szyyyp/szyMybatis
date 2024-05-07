package com.bupt.result.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LtrPageable<T> {
    public enum Order {

        /**
         * 递增
         */
        asc,

        /**
         * 递减
         */
        desc;


    }

    /**
     * 默认排序方向
     */
    private static final Order DEFAULT_ORDER = Order.desc;


    /**
     * 默认排序属性
     */
    private static final String DEFAULT_SORT = "id";

    /**
     * 默认当前页码
     */
    private static final Integer DEFAULT_PAGE = 1;

    /**
     * 默认每页记录数
     */
    private static final Integer DEFAULT_SIZE = 10;

    /**
     * 当前页码
     */
    private Integer page = DEFAULT_PAGE;

    /**
     * 每页记录数
     */
    private Integer size = DEFAULT_SIZE;

    /**
     * 排序属性
     */
    private String sort = DEFAULT_SORT;

    /**
     * 排序方向
     */
    private Order order = DEFAULT_ORDER;

    /**
     * 前端 String 类型排序方向
     */
    private String stringOrder;

    /**
     * 工作组 id
     */
    private Integer workgroupId;

    /**
     * 筛选
     */
    private List<LtrFilter> filters = new ArrayList<>();

    /**
     * 前端传递分页实体类
     */
    private T t;

    /**
     * 从String中获取Order
     *
     * @param value 值
     * @return String对应的Order
     */
    public static Order fromString(String value) {
        return Order.valueOf(value.toLowerCase());
    }
}
