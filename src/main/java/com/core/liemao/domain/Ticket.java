package com.core.liemao.domain;

import java.sql.Timestamp;

import com.core.liemao.domain.request.Paging;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:47:22 
 * 类说明 
 */
public class Ticket extends Paging{
	private Integer id;
	private String frontImg;
	private String backImg;
	private Integer userId;
	private Timestamp createTime;
	private Integer verifyResult;
	private String reason;
	private Timestamp verifyTime;
	private Integer isRead;
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
	 * @return the frontImg
	 */
	public String getFrontImg() {
		return frontImg;
	}
	/**
	 * @param frontImg the frontImg to set
	 */
	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}
	/**
	 * @return the backImg
	 */
	public String getBackImg() {
		return backImg;
	}
	/**
	 * @param backImg the backImg to set
	 */
	public void setBackImg(String backImg) {
		this.backImg = backImg;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	/**
	 * @return the verifyResult
	 */
	public Integer getVerifyResult() {
		return verifyResult;
	}
	/**
	 * @param verifyResult the verifyResult to set
	 */
	public void setVerifyResult(Integer verifyResult) {
		this.verifyResult = verifyResult;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the verifyTime
	 */
	public Timestamp getVerifyTime() {
		return verifyTime;
	}
	/**
	 * @param verifyTime the verifyTime to set
	 */
	public void setVerifyTime(Timestamp verifyTime) {
		this.verifyTime = verifyTime;
	}
	/**
	 * @return the isRead
	 */
	public Integer getIsRead() {
		return isRead;
	}
	/**
	 * @param isRead the isRead to set
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	
	
}
