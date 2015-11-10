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
import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;
import com.core.liemao.domain.request.TicketReq;
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
	 *  微信绑定
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/binding")
	@ResponseBody
	public ResultObject<User> binding(User user) throws Exception{
		ResultObject<User> result = new ResultObject<User>();
		user = userService.binding(user);
		result.setDomain(user);
		return result;
	}
	/**
	 *  发送短信验证码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/send/verification_code")
	@ResponseBody
	public ResultObject<String> sendVerificationCode(User user) throws Exception{
		ResultObject<String> result = new ResultObject<String>();
		String code  = userService.sendVerificationCode(user);
		result.setDomain(code);
		return result;
	}
	/**
	 * 验证短信验证码
	 * @return
	 */
	@RequestMapping(value="/verification_code")
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
	@RequestMapping(value="/update_info")
	@ResponseBody
	public ResultObject<User> updateInfo(User user) throws Exception{
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
	@RequestMapping(value="/get/region")
	@ResponseBody
	public ResultList<Region> updateInfo(Region region) throws Exception{
		ResultList<Region> result = new ResultList<Region>();
		result.setItemList(userService.getRegion(region));
		return result;
	}
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/get_info")
	@ResponseBody
	public ResultObject<User> getUserInfo(User user) throws Exception{
		ResultObject<User> result = new ResultObject<User>();
		result.setDomain(userService.getUserInfo(user));
		return result;
	}
	
	/**
	 * 用户添加反馈
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/feedback/add")
	@ResponseBody
	public ResultObject<Feedback> feedbackAdd(Feedback feedback) throws Exception{
		ResultObject<Feedback> result = new ResultObject<Feedback>();
		result.setDomain(userService.feedbackAdd(feedback));
		return result;
	}
	
	/**
	 * 用户添加反馈
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/feedback/list")
	@ResponseBody
	public ResultList<Feedback> feedbackList(Feedback feedback) throws Exception{
		ResultList<Feedback> result = new ResultList<Feedback>();
		result.setItemList(userService.feedbackList(feedback));
		return result;
	}
	
	/**
	 * 回复用户反馈
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/feedback/reply")
	@ResponseBody
	public ResultObject<Feedback> feedbackReply(Feedback feedback) throws Exception{
		ResultObject<Feedback> result = new ResultObject<Feedback>();
		result.setDomain(userService.feedbackReply(feedback));
		return result;
	}
	
	/**
	 * 用户反馈详情
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/feedback/detail")
	@ResponseBody
	public ResultObject<Feedback> feedbackDetail(Feedback feedback) throws Exception{
		ResultObject<Feedback> result = new ResultObject<Feedback>();
		result.setDomain(userService.feedbackDetail(feedback));
		return result;
	}
	
	/**
	 * 用户反馈详情
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/feedback/mark_read")
	@ResponseBody
	public Result feedbackMarkRead(Feedback feedback) throws Exception{
		userService.feedbackMarkRead(feedback);
		return new Result();
	}
	/**
	 * 系统用户登录
	 * @param Feedback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sys_login")
	public String sysLogin(User user,Map<String, Object> model,HttpSession httpSession) throws Exception{
		String result = userService.sysLogin(user);
		if(null != result){
			model.put("errorMsg", result);
			return "index";
		}
		httpSession.setAttribute("user", user);
		httpSession.setAttribute("imgBasePath", "http://114.215.172.198/");
		return "redirect:/ticket/manager?verifyResult=0";
	}
	
	@RequestMapping("/feedback/manager")
	public String feedbackManager(Map<String, Object> model,Feedback feedback,HttpSession session) throws Exception{
		model.put("feedback", feedback);
		List<Feedback> list = userService.feedbackManager(feedback);
		model.put("list", list);
		return "feedbackManager";
	}

}