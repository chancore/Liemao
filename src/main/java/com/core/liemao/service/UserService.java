package com.core.liemao.service;

import java.util.List;

import com.core.liemao.domain.Feedback;
import com.core.liemao.domain.News;
import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月21日 下午1:44:37 
 * 类说明 
 */
public interface UserService {
	/**
	 * 发送短信验证码
	 * @param user
	 */
	public String sendVerificationCode(User user) throws Exception;
	
	/**
	 * 微信绑定
	 * @param user
	 * @return
	 */
	public User binding(User user) throws Exception;
	/**
	 * 验证短信
	 * @param user
	 */
	public void verificationCode(User user) throws Exception;
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User updateUserInfo(User user) throws Exception;
	/**
	 * 获取地区信息
	 * @param region
	 * @return
	 */
	public List<Region> getRegion(Region region) throws Exception ;
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getUserInfo(User user) throws Exception;
	/**
	 * 用户添加反馈
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public Feedback feedbackAdd(Feedback feedback) throws Exception;
	/**
	 * 反馈列表
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public List<Feedback> feedbackList(Feedback feedback) throws Exception;
	/**
	 * 回复用户反馈
	 * @param feedback
	 * @return
	 */
	public Feedback feedbackReply(Feedback feedback);
	/**
	 *  用户反馈详情
	 * @param feedback
	 * @return
	 */
	public Feedback feedbackDetail(Feedback feedback);
	/**
	 *  用户反馈标记为已读
	 * @param feedback
	 * @return
	 */
	public void feedbackMarkRead(Feedback feedback);
	/**
	 * 系统用户登录
	 * @param user
	 */
	public String sysLogin(User user);
	/**
	 * 咨询管理
	 * @param feedback
	 * @return
	 */
	public List<Feedback> feedbackManager(Feedback feedback);
	/**
	 * 用户管理
	 * @param user
	 * @return
	 */
	public List<User> userManager(User user);
	
	public News getNewsDetail(News news);
	public News modifyNews(News news);
	
}
