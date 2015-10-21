package com.core.liemao.domain;

import java.sql.Timestamp;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月20日 下午9:51:47 
 * 类说明 
 */
public class User {
	
	private Integer id;
	private String phone;
	private String weixinToken;
	private Timestamp createTime;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the weixinToken
	 */
	public String getWeixinToken() {
		return weixinToken;
	}
	/**
	 * @param weixinToken the weixinToken to set
	 */
	public void setWeixinToken(String weixinToken) {
		this.weixinToken = weixinToken;
	}
	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	

}
