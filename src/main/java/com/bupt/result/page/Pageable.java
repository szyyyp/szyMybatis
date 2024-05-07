package com.bupt.result.page;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pageable {

	protected List<OrderItem> orders;

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
	 * 前端 String 类型排序方向
	 */
	private String stringOrder;

	/**
	 * 筛选
	 */
	private List<Filter> filters = new ArrayList<>();

	/**
	 * 从String中获取Order
	 *
	 * @param value 值
	 * @return String对应的Order
	 */
}