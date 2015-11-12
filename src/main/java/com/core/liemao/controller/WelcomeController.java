package com.core.liemao.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.liemao.domain.News;
import com.core.liemao.service.UserService;


/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月5日 下午11:01:00 
 * 类说明 
 */
@Controller
public class WelcomeController {
	
	@Autowired
	private UserService userService;
	
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
		News news = new News();
		news.setId(1);
		model.put("news", userService.getNewsDetail(news));
		return "zxlv";
	}
	
	/**
	 * 关于我们
	 * @param model
	 * @return
	 */
	@RequestMapping("/gywm")
	public String gywm(Map<String, Object> model){
		News news = new News();
		news.setId(2);
		model.put("news", userService.getNewsDetail(news));
		return "gywm";
	}
	
	
}