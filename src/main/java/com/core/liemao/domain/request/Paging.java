package com.core.liemao.domain.request;

public class Paging {
	private Integer start = 0;		// 分页
	private Integer limit = 20;      //
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		if(limit!=null && limit==0){
			limit = null;
			start = null;
		}
		this.limit = limit;
	}
}
