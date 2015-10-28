package com.core.liemao.domain;

import java.sql.Timestamp;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月25日 下午4:43:30 
 * 类说明 
 */
public class VerificationCode{

	
	private Integer id;
	
	private String phone;
	
	private String code;
	
	private Timestamp CreateTime;

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return CreateTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	
	
}
