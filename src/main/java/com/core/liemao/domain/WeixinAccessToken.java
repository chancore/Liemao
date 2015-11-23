package com.core.liemao.domain;

import java.sql.Timestamp;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月22日 下午9:54:06 
 * 类说明 
 */
public class WeixinAccessToken {
	
	private Integer id;
	private String accessToken;
	private String jsapiToken;
	private Integer validtime;
	private Timestamp createtime;
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
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the jsapiToken
	 */
	public String getJsapiToken() {
		return jsapiToken;
	}
	/**
	 * @param jsapiToken the jsapiToken to set
	 */
	public void setJsapiToken(String jsapiToken) {
		this.jsapiToken = jsapiToken;
	}
	/**
	 * @return the validtime
	 */
	public Integer getValidtime() {
		return validtime;
	}
	/**
	 * @param validtime the validtime to set
	 */
	public void setValidtime(Integer validtime) {
		this.validtime = validtime;
	}
	/**
	 * @return the createtime
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	

}
