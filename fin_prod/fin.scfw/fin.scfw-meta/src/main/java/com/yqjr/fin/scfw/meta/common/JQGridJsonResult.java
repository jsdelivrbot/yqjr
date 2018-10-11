package com.yqjr.fin.scfw.meta.common;

import java.util.List;

public class JQGridJsonResult<T> {
	private Integer page;  			//当前页码
	private Integer total;  		//总页数
	private Long records;		//总记录数
	private List<T> rows; 		//数据集合
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Long getRecords() {
		return records;
	}
	public void setRecords(Long records) {
		this.records = records;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
