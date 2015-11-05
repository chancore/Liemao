package com.core.liemao.service;

import java.util.List;

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
	 * 注册用户
	 * @param user
	 * @return
	 */
	public User register(User user) throws Exception;
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

}
