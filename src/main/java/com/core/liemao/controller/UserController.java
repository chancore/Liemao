package com.core.liemao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;
import com.core.liemao.domain.response.Result;
import com.core.liemao.domain.response.ResultList;
import com.core.liemao.domain.response.ResultObject;
import com.core.liemao.service.UserService;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月20日 下午6:16:33 
 * 类说明 
 */
@Controller
@RequestMapping(value="/user",produces="application/json;charset=UTF-8")
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public ResultObject<User> register(@RequestBody User user) throws Exception{
		ResultObject<User> result = new ResultObject<User>();
		user = userService.register(user);
		result.setDomain(user);
		return result;
	}
	/**
	 *  发送短信验证码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/send/verification_code",method=RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> sendVerificationCode(@RequestBody User user) throws Exception{
		ResultObject<String> result = new ResultObject<String>();
		String code  = userService.sendVerificationCode(user);
		result.setDomain(code);
		return result;
	}
	/**
	 * 验证短信验证码
	 * @return
	 */
	@RequestMapping(value="/verification_code",method=RequestMethod.POST)
	@ResponseBody
	public Result verificationCode(){
		Result result = new Result();
		return result;
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update_info",method=RequestMethod.POST)
	@ResponseBody
	public ResultObject<User> updateInfo(@RequestBody User user) throws Exception{
		ResultObject<User> result = new ResultObject<User>();
		user = userService.updateUserInfo(user);
		result.setDomain(user);
		return result;
	}
	
	/**
	 * 获取地区信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/get/region",method=RequestMethod.GET)
	@ResponseBody
	public ResultList<Region> updateInfo(Region region) throws Exception{
		ResultList<Region> result = new ResultList<Region>();
		result.setItemList(userService.getRegion(region));
		return result;
	}

}