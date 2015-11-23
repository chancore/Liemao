package com.core.liemao.domain;

import java.util.Map;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月22日 下午10:19:47 
 * 类说明 
 */
public class WeixinTestContent {

	
	private Map<String,Object> filter ;
	
	private Map<String, Object> text;
	
	private String msgtype ;

	/**
	 * @return the filter
	 */
	public Map<String, Object> getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(Map<String, Object> filter) {
		this.filter = filter;
	}

	/**
	 * @return the text
	 */
	public Map<String, Object> getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(Map<String, Object> text) {
		this.text = text;
	}

	/**
	 * @return the msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}

	/**
	 * @param msgtype the msgtype to set
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	
}
