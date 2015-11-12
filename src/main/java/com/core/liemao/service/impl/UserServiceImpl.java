package com.core.liemao.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.core.liemao.domain.Feedback;
import com.core.liemao.domain.News;
import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;
import com.core.liemao.domain.VerificationCode;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.exception.ServerException;
import com.core.liemao.persistence.UserMapper;
import com.core.liemao.service.UserService;
import com.core.liemao.utils.EncryptionByMD5;
import com.core.liemao.utils.StringEx;
import com.core.liemao.utils.YunpianSmsUtil;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月21日 下午1:45:40 
 * 类说明 
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User binding(User user) throws Exception{
		if(null == user.getCode() || user.getCode().trim().isEmpty()){
			throw new ServerException(ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorMessageToUser());
		}
		if(null == user.getPhone() || user.getPhone().trim().isEmpty()){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		if(null == user.getWeixinId() || user.getWeixinId().trim().isEmpty()){
			throw new ServerException(ErrorConstant.WEIXINID_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.WEIXINID_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		User weixinUser = userMapper.getUserForWeixinId(user.getWeixinId());
		if(null == weixinUser){
			VerificationCode verificationCode = new VerificationCode();
			verificationCode.setCode(user.getCode());
			verificationCode.setPhone(user.getPhone());
			VerificationCode vCode = userMapper.verificationCode(verificationCode);
			if(null == vCode){
				throw new ServerException(ErrorConstant.VERIFICATION_CODE_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_ERROR.getErrorMessageToUser());
			}
			User userPhone = userMapper.getUserForPhone(user.getPhone());
			if(null != userPhone){
				throw new ServerException(ErrorConstant.PHONE_ALREADY_EXISTS.getErrorCode(), ErrorConstant.PHONE_ALREADY_EXISTS.getErrorMessageToUser());
			}
			userMapper.registerUser(user);
		}else {
			if(!weixinUser.getPhone().equals(user.getPhone())){
				throw new ServerException(ErrorConstant.BOODING_FAIL.getErrorCode(),"该微信号已经绑定尾号为"+weixinUser.getPhone().substring(7, 11)+"的手机");
			}
			VerificationCode verificationCode = new VerificationCode();
			verificationCode.setCode(user.getCode());
			verificationCode.setPhone(user.getPhone());
			VerificationCode vCode = userMapper.verificationCode(verificationCode);
			if(null == vCode){
				throw new ServerException(ErrorConstant.VERIFICATION_CODE_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_ERROR.getErrorMessageToUser());
			}
		}
	    user = userMapper.getUserForWeixinId(user.getWeixinId());
		return user;
	}

	@Override
	public String sendVerificationCode(User user) throws Exception{
		if(user.getPhone() == null || user.getPhone().trim().isEmpty()){ 
			throw new ServerException(ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		if(!StringEx.verificationPhone(user.getPhone())){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_FORMAT_ERROR.getErrorCode(), ErrorConstant.PHONE_NUMBER_FORMAT_ERROR.getErrorMessageToUser());
		}
		String code = StringEx.getRandomInteger(4);
		String result = YunpianSmsUtil.sendVerificationCode(code, user.getPhone());
		JSONObject resultObject = JSON.parseObject(result);
		Integer sendCode = Integer.parseInt(resultObject.get("code").toString());
		if(sendCode != 0){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_FORMAT_ERROR.getErrorCode(), resultObject.get("detail").toString());
		}
		
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setPhone(user.getPhone());
		verificationCode.setCode(code);
		userMapper.addVerificationCode(verificationCode);
		return code;
	}

	@Override
	public void verificationCode(User user) throws Exception {
		if(user.getPhone() == null || user.getPhone().isEmpty()){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		if(user.getCode() == null || user.getCode().isEmpty()){
			throw new ServerException(ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorMessageToUser());
		}
		//校验验证码是否正确
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setPhone(user.getPhone());
		verificationCode.setCode(user.getCode());
		verificationCode = userMapper.verificationCode(verificationCode);
		if(verificationCode == null){
			throw new ServerException(ErrorConstant.VERIFICATION_CODE_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_ERROR.getErrorMessageToUser());
		}
	}

	@Override
	public User updateUserInfo(User user) throws Exception {
	    if(null == user.getId()){
	    	throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
	    }
	    userMapper.updateUserInfo(user);
	    return user;
	}

	@Override
	public List<Region> getRegion(Region region) throws Exception {
		if(region.getParentId() == null){
			throw new ServerException(ErrorConstant.PARENT_ID_NOT_NULL.getErrorCode(), ErrorConstant.PARENT_ID_NOT_NULL.getErrorMessageToUser());
		}
		if(region.getType() == null){
			throw new ServerException(ErrorConstant.TYPE_NOT_NULL.getErrorCode(), ErrorConstant.TYPE_NOT_NULL.getErrorMessageToUser());
		}
		return userMapper.getRegion(region);
	}

	@Override
	public User getUserInfo(User user) throws Exception {
		if(user.getId() == null){
			throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
		}
		return userMapper.getUserById(user.getId());
	}

	@Override
	public Feedback feedbackAdd(Feedback feedback) throws Exception {
		if(feedback.getContent() == null){
			throw new ServerException(ErrorConstant.FEEDBACK_CONTENT_NOT_NULL.getErrorCode(), ErrorConstant.FEEDBACK_CONTENT_NOT_NULL.getErrorMessageToUser());
		}
		if(feedback.getUserId() == null){
			throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
		}
		userMapper.feedbackAdd(feedback);
		return feedback;
	}

	@Override
	public List<Feedback> feedbackList(Feedback feedback) throws Exception {
		if(feedback.getUserId() == null){
			throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
		}
		return userMapper.feedbackList(feedback);
	}

	@Override
	public Feedback feedbackReply(Feedback feedback) {
		if(feedback.getId() == null){
			throw new ServerException(ErrorConstant.ID_NOT_NULL.getErrorCode(), ErrorConstant.ID_NOT_NULL.getErrorMessageToUser());
		}
		if(feedback.getFeedback() == null){
			throw new ServerException(ErrorConstant.FEEDBACK_NOT_NULL.getErrorCode(), ErrorConstant.FEEDBACK_NOT_NULL.getErrorMessageToUser());
		}
		userMapper.feedbackReply(feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackDetail(Feedback feedback) {
		if(feedback.getId() == null){
			throw new ServerException(ErrorConstant.ID_NOT_NULL.getErrorCode(), ErrorConstant.ID_NOT_NULL.getErrorMessageToUser());
		}
		
		return userMapper.feedbackDetail(feedback);
	}
	
	@Override
	public void feedbackMarkRead(Feedback feedback) {
		if(feedback.getId() == null){
			throw new ServerException(ErrorConstant.ID_NOT_NULL.getErrorCode(), ErrorConstant.ID_NOT_NULL.getErrorMessageToUser());
		}
		userMapper.feedbackMarkRead(feedback);
	}

	@Override
	public String sysLogin(User user) {
		String errotMsg = "用户名或密码错误";
		if(null != user.getPwd()){
			String pwd = EncryptionByMD5.getMD5(user.getPwd().getBytes());
			user.setPwd(pwd);
		}
		User sysUser = userMapper.getSysUser(user);
		if(null == sysUser){
			return "用户名或密码错误";
		}
		return null;
	}

	@Override
	public List<Feedback> feedbackManager(Feedback feedback) {
		
		return userMapper.feedbackManager(feedback);
	}

	@Override
	public List<User> userManager(User user) {
		
		return userMapper.userManager(user);
	}

	@Override
	public News getNewsDetail(News news) {
		
		return userMapper.getNewsDetail(news);
	}
	
	@Override
	public News modifyNews(News news) {
		userMapper.modifyNews(news);
		userMapper.addNewsHistory(news);
		return news;
	}
}