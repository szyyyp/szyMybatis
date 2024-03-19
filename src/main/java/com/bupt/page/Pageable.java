package com.bupt.page;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息
 * 
 */
@Data
public class Pageable implements Serializable {

	/** 默认页码 */
	private static final int DEFAULT_PAGE_NUMBER = 1;

	/** 默认每页记录数 */
	private static final int DEFAULT_PAGE_SIZE = 20;

	/** 最大每页记录数 */
	private static final int MAX_PAGE_SIZE = 10000;

	/** 页码 */
	private int page = DEFAULT_PAGE_NUMBER;	//当前页,easyui 名字必须为page

	/** 每页记录数 */
	private int rows = DEFAULT_PAGE_SIZE;	//每页大小,easyui 名字必须为rows

	/** 搜索属性 */
	private String searchProperty;

	/** 搜索值 */
	private String searchValue;

	/** 排序属性 */
	private String orderProperty;

	/** 排序方向 */
	private Order.Direction orderDirection;
	
	String sort;	//排序字段 easyui
	String order;	//排序规则 easyui

	/** 筛选 */
	private List<Filter> filters = new ArrayList<>();

	/** 排序 */
	private List<Order> orders = new ArrayList<>();

	/**
	 * 初始化一个新创建的Pageable对象
	 */
	public Pageable() {
	}

	/**
	 * 初始化一个新创建的Pageable对象
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页记录数
	 */
	public Pageable(Integer page, Integer rows) {
		if (page != null && page >= 1) {
			this.page = page;
		}
		if (rows != null && rows >= 1 && rows <= MAX_PAGE_SIZE) {
			this.rows = rows;
		}
	}

	/**
	 * 设置页码
	 * 
	 * @param page
	 *            页码
	 */
	public void setPage(int page) {
		if (page < 1) {
			page = DEFAULT_PAGE_NUMBER;
		}
		this.page = page;
	}

	/**
	 * 设置每页记录数
	 * 
	 * @param rows
	 *            每页记录数
	 */
	public void setRows(int rows) {
		if (rows < 1 || rows > MAX_PAGE_SIZE) {
			rows = DEFAULT_PAGE_SIZE;
		}
		this.rows = rows;
	}


}