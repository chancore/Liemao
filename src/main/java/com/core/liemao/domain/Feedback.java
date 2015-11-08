package com.core.liemao.domain;

import java.sql.Timestamp;

import com.core.liemao.domain.request.Paging;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月8日 下午1:00:09 
 * 类说明 
 */
public class Feedback extends Paging{
	
	
	private Integer id;
	private String title;
	private String content;
	private Timestamp createTime;
	private String feedback;
	private Integer userId;
	private Timestamp feedbackTime;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * @return the feedbackTime
	 */
	public Timestamp getFeedbackTime() {
		return feedbackTime;
	}
	/**
	 * @param feedbackTime the feedbackTime to set
	 */
	public void setFeedbackTime(Timestamp feedbackTime) {
		this.feedbackTime = feedbackTime;
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
