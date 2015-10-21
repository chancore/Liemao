package com.core.liemao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.liemao.domain.User;
import com.core.liemao.domain.response.Result;
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
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Result register(@RequestBody User user){
		Result result = new Result();
		return result;
	}
	
	@RequestMapping(value="/send/verification_code",method=RequestMethod.POST)
	@ResponseBody
	public Result sendVerificationCode(@RequestBody User user) throws Exception{
		Result result = new Result();
		userService.sendVerificationCode(user);
		return result;
	}

}