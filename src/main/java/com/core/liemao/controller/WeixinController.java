package com.core.liemao.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.security.provider.MD5;

import com.core.liemao.domain.Feedback;
import com.core.liemao.domain.Keyword;
import com.core.liemao.domain.News;
import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.domain.response.Result;
import com.core.liemao.domain.response.ResultList;
import com.core.liemao.domain.response.ResultObject;
import com.core.liemao.service.UserService;
import com.core.liemao.service.WeixinService;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月20日 下午6:16:33 
 * 类说明
 */
@Controller
@RequestMapping(value="/weixin",produces="application/json;charset=UTF-8")
@EnableAutoConfiguration
public class WeixinController {
	
	@Autowired
	private WeixinService weixinService;
	/**
	 *  微信绑定
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/send/batch_msg",method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> sendMsg(Keyword keyword) throws Exception{
		ResultObject<String> result = new ResultObject<String>();
		String msg = weixinService.sendBatchMsg(keyword);
		result.setDomain(msg);
		return result;
	}
	
}