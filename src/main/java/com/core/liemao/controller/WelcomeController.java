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
	/**
	 * 最新利率链接
	 * @param model
	 * @return
	 */
	@RequestMapping("/zxlv")
	public String zxlv(Map<String, Object> model){
		model.put("time", new Date());
		return "zxlv";
	}
	
	/**
	 * 关于我们
	 * @param model
	 * @return
	 */
	@RequestMapping("/gywm")
	public String gywm(Map<String, Object> model){
		model.put("time", new Date());
		return "gywm";
	}
	
	
}