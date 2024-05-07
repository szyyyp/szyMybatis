package com.bupt.result.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LtrFilter {
    public enum Operator {

        /**
         * 等于
         */
        eq,

        /**
         * 不等于
         */
        ne,

        /**
         * 大于
         */
        gt,

        /**
         * 小于
         */
        lt,

        /**
         * 大于等于
         */
        ge,

        /**
         * 小于等于
         */
        le,

        /**
         * 在...之间
         */
        bt,

        /**
         * 不在...之间
         */
        nb,

        /**
         * 相似(模糊查询like)
         */
        ct,

        /**
         * 包含(in)
         */
        il,

        /**
         * 为Null
         */
        nl,

        /**
         * 不为Null
         */
        nn,

        /**
         * 为空(仅字符串)
         */
        ey,

        /**
         * 不为空(仅字符串)
         */
        ny
    }

    /**
     * 属性
     */
    private String property;

    /**
     * 运算符
     */
    private Operator operator;

    /**
     * 值
     */
    private Object value;

    /**
     * 前端 String 类型运算符
     */
    private String stringOperator;

    /**
     * 从String中获取Operator
     *
     * @param value 值
     * @return String对应的operator
     */
    public static Operator fromString(String value) {
        return Operator.valueOf(value.toLowerCase());
    }

    //将 object 转换为 object[]
    public <T> Object[] castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result.toArray();
        }
        return null;
    }


}

