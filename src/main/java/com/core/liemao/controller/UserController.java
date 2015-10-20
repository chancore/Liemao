package com.core.liemao.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月20日 下午6:16:33 
 * 类说明 
 */
@Controller
@RequestMapping(value="/user")
@EnableAutoConfiguration
public class UserController {
	
	@RequestMapping(value="/test1",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		
		return "123";
	}

}