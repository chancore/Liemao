package com.core.liemao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.core.liemao.domain.User;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.exception.ServerException;
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

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public void sendVerificationCode(User user) throws Exception{
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
		System.out.println(resultObject.toJSONString());
		Integer sendCode = Integer.parseInt(resultObject.get("code").toString());
		if(sendCode != 0){
			throw new ServerException(ErrorConstant.PHONE_NUMBER_FORMAT_ERROR.getErrorCode(), resultObject.get("detail").toString());
		}
	}
}