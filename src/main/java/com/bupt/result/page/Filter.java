package com.bupt.result.page;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 筛选
 * 查询条件
 */
@Data
public class Filter implements Serializable {

	@Serial
	private static final long serialVersionUID = -8712382358441065075L;

	/**
	 * 运算符
	 */
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
		ny,

	}

	/** 默认是否忽略大小写 */
	private static final boolean DEFAULT_IGNORE_CASE = false;

	/** 属性 */
	private String property;

	/** 运算符 */
	private Operator operator;

	/**
	 * 前端 String 类型运算符
	 */
	private String stringOperator;

	/** 值 */
	private Object value;

	/** 是否忽略大小写 */
	private Boolean ignoreCase = DEFAULT_IGNORE_CASE;

	/**
	 * 初始化一个新创建的Filter对象
	 */
	public Filter() {
	}

	/**
	 * 初始化一个新创建的Filter对象
	 * 
	 * @param property
	 *            属性
	 * @param operator
	 *            运算符
	 * @param value
	 *            值
	 */
	public Filter(String property, Operator operator, Object value) {
		this.property = property;
		this.operator = operator;
		this.value = value;
	}

	/**
	 * 初始化一个新创建的Filter对象
	 * 
	 * @param property
	 *            属性
	 * @param operator
	 *            运算符
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 */
	public Filter(String property, Operator operator, Object value, boolean ignoreCase) {
		this.property = property;
		this.operator = operator;
		this.value = value;
		this.ignoreCase = ignoreCase;
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 等于筛选
	 */
	public static Filter eq(String property, Object value) {
		return new Filter(property, Operator.eq, value);
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 等于筛选
	 */
	public static Filter eq(String property, Object value, boolean ignoreCase) {
		return new Filter(property, Operator.eq, value, ignoreCase);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 不等于筛选
	 */
	public static Filter ne(String property, Object value) {
		return new Filter(property, Operator.ne, value);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 不等于筛选
	 */
	public static Filter ne(String property, Object value, boolean ignoreCase) {
		return new Filter(property, Operator.ne, value, ignoreCase);
	}

	/**
	 * 返回大于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于筛选
	 */
	public static Filter gt(String property, Object value) {
		return new Filter(property, Operator.gt, value);
	}

	/**
	 * 返回小于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于筛选
	 */
	public static Filter lt(String property, Object value) {
		return new Filter(property, Operator.lt, value);
	}

	/**
	 * 返回大于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于等于筛选
	 */
	public static Filter ge(String property, Object value) {
		return new Filter(property, Operator.ge, value);
	}

	/**
	 * 返回小于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于等于筛选
	 */
	public static Filter le(String property, Object value) {
		return new Filter(property, Operator.le, value);
	}

	/**
	 * 返回相似筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 相似筛选
	 */
	public static Filter like(String property, Object value) {
		return new Filter(property, Operator.ct, value);
	}

	/**
	 * 返回包含筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 包含筛选
	 */
	public static Filter in(String property, Object value) {
		return new Filter(property, Operator.il, value);
	}

	/**
	 * 返回为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 为Null筛选
	 */
	public static Filter isNull(String property) {
		return new Filter(property, Operator.nl, null);
	}

	/**
	 * 返回不为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 不为Null筛选
	 */
	public static Filter isNotNull(String property) {
		return new Filter(property, Operator.nn, null);
	}

	/**
	 * 返回忽略大小写筛选
	 * 
	 * @return 忽略大小写筛选
	 */
	public Filter ignoreCase() {
		this.ignoreCase = true;
		return this;
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

	/**
	 * 从String中获取Operator
	 *
	 * @param value
	 *            值
	 * @return String对应的operator
	 */
	public static Operator fromString(String value) {
		return Operator.valueOf(value.toLowerCase());
	}
}