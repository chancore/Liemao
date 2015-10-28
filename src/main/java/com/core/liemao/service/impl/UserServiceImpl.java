package com.core.liemao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.core.liemao.domain.User;
import com.core.liemao.domain.VerificationCode;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.exception.ServerException;
import com.core.liemao.persistence.UserMapper;
import com.core.liemao.service.UserService;
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
	public User register(User user) throws Exception{
		if(null == user.getCode() || user.getCode().trim().isEmpty()){
			throw new ServerException(ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_FORMAT_ERROR.getErrorMessageToUser());
		}
		if(null == user.getPhone() || user.getPhone().trim().isEmpty()){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.PHONE_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		if(null == user.getWeixinId() || user.getWeixinId().trim().isEmpty()){
			throw new ServerException(ErrorConstant.WEIXINID_NUMBER_NOT_NULL.getErrorCode(), ErrorConstant.WEIXINID_NUMBER_NOT_NULL.getErrorMessageToUser());
		}
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(user.getCode());
		verificationCode.setPhone(user.getPhone());
		VerificationCode vCode = userMapper.verificationCode(verificationCode);
		if(null == vCode){
			throw new ServerException(ErrorConstant.VERIFICATION_CODE_ERROR.getErrorCode(), ErrorConstant.VERIFICATION_CODE_ERROR.getErrorMessageToUser());
		}
		//查询用户是否已经存在
		User userData = userMapper.getUserForPhone(user.getPhone());
		if(userData != null){
			throw new ServerException(ErrorConstant.USER_ALREADY_EXISTS.getErrorCode(), ErrorConstant.USER_ALREADY_EXISTS.getErrorMessageToUser());
		}
		User weixinUser = userMapper.getUserForWeixinId(user.getWeixinId());
		if(weixinUser != null){
			throw new ServerException(ErrorConstant.WEIXIN_USER_ALREADY_EXISTS.getErrorCode(), ErrorConstant.WEIXIN_USER_ALREADY_EXISTS.getErrorMessageToUser());
		}
		userMapper.registerUser(user);
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
		logger.info(code);
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
	
	
	
}