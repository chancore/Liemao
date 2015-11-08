package com.core.liemao.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月5日 下午11:01:00 
 * 类说明 
 */
@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String index(Map<String, Object> model){
		model.put("time", new Date());
		return "index";
	}
}