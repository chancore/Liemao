package com.core.liemao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.core.liemao.common.Constant;
import com.core.liemao.controller.WeixinController;
import com.core.liemao.domain.First;
import com.core.liemao.domain.Keyword;
import com.core.liemao.domain.WeixinAccessToken;
import com.core.liemao.domain.WeixinTestContent;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.exception.ServerException;
import com.core.liemao.persistence.WeixinMapper;
import com.core.liemao.service.WeixinService;
import com.core.liemao.utils.DateUtils;
import com.core.liemao.utils.HttpClientUtil;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月22日 下午9:58:17 
 * 类说明 
 */
@Service
public class WeixinServiceImpl implements WeixinService{
	
	@Autowired
	private WeixinMapper weixinMapper;
	
	@Override
	public String sendBatchMsg(Keyword keyword) throws Exception {
		if(null == keyword.getValue() || keyword.getValue().trim().isEmpty()){
			throw new ServerException(ErrorConstant.MESSAGE_NOT_NULL.getErrorCode(),ErrorConstant.MESSAGE_NOT_NULL.getErrorMessageToUser());
		}
		WeixinAccessToken accessToken = weixinMapper.getWeixinAccessToken();
		WeixinTestContent wc = new WeixinTestContent();
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("is_to_all", true);
		wc.setFilter(filter);
		Map<String, Object> text = new HashMap<String, Object>();
		text.put("content", keyword.getValue());
		wc.setText(text);
		wc.setMsgtype("text");
		String jsonContent = JSON.toJSONString(wc);
		String result = sendMsg(accessToken,jsonContent);
		
		JSONObject obj = JSON.parseObject(result);
		Integer errorCode = Integer.parseInt(obj.get("errcode").toString());
		//token 过期
		if(errorCode == 42001){
			String weixinTokenResult = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.WEIXINAPPID+"&secret="+Constant.WEIXINAPPSECRET);
			JSONObject weixinTokenJSON = JSON.parseObject(weixinTokenResult);
			String token = weixinTokenJSON.getString("access_token");
			weixinMapper.updateAccessToken(token, System.currentTimeMillis());
			accessToken =  weixinMapper.getWeixinAccessToken();
			result = sendMsg(accessToken,jsonContent);
		}
		return result;
	}
	
	private String sendMsg(WeixinAccessToken accessToken,String jsonContent){ 
		String result = HttpClientUtil.doJSONPost("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+accessToken.getAccessToken(), 
				jsonContent);
		return result;
	}

	@Override
	public String sendApproved(String openId) {
		WeixinAccessToken accessToken = weixinMapper.getWeixinAccessToken();
		Map param = new HashMap<>();
		param.put("touser", openId);
		param.put("template_id", "NNGXBXWpWzJE5hirlUJwXQxxLnwewYjXK3x__a_Ux5s");
		Map data = new HashMap();
		First first = new First("亲爱的用户,验票审核通过", Constant.color);
		data.put("first", first);
		Keyword keyword1 = new Keyword("验票审核通过",Constant.color);
		data.put("keyword1", keyword1);
		Keyword keyword2 = new Keyword("系统操作员",Constant.color);
		data.put("keyword2", keyword2);
		String modifyTime = DateUtils.TimestampToStr(System.currentTimeMillis());
		Keyword keyword3 = new Keyword(modifyTime,Constant.color);
		data.put("keyword3", keyword3);
		Keyword remark = new Keyword("您的验票信息审核通过啦,请到\n\"我的\"-\"我的查验\"查看详情",Constant.color);
		data.put("remark", remark);
		param.put("data", data);
		String jsonContent =  JSON.toJSONString(param);
		String result = sendApprovedData(accessToken,jsonContent);
		JSONObject obj = JSON.parseObject(result);
		Integer errorCode = Integer.parseInt(obj.get("errcode").toString());
		if(errorCode == 42001){
			String weixinTokenResult = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.WEIXINAPPID+"&secret="+Constant.WEIXINAPPSECRET);
			JSONObject weixinTokenJSON = JSON.parseObject(weixinTokenResult);
			String token = weixinTokenJSON.getString("access_token");
			weixinMapper.updateAccessToken(token, System.currentTimeMillis());
			accessToken =  weixinMapper.getWeixinAccessToken();
			result = sendApprovedData(accessToken,jsonContent);
		}
		return result;
	}
	
	private String sendApprovedData(WeixinAccessToken accessToken,String jsonContent){
		String result = HttpClientUtil.doJSONPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken.getAccessToken(), 
				jsonContent);
		
		return result;
	}

	@Override
	public String sendUnapprove(String openId, String reason) {
		WeixinAccessToken accessToken = weixinMapper.getWeixinAccessToken();
		Map param = new HashMap<>();
		param.put("touser", openId);
		param.put("template_id", "br6Cs8n5zoz5_bzTBhrfwM6AaJOI7eKyxJtWy-iGGBc");
		Map data = new HashMap();
		First first = new First("亲爱的用户,验票审核未通过", Constant.color);
		data.put("first", first);
		Keyword keyword1 = new Keyword("验票审核未通过",Constant.color);
		data.put("keyword1", keyword1);
		Keyword keyword2 = new Keyword(reason,"#E80000");
		data.put("keyword2", keyword2);
		String modifyTime = DateUtils.TimestampToStr(System.currentTimeMillis());
		Keyword keyword3 = new Keyword(modifyTime,Constant.color);
		data.put("keyword3", keyword3);
		Keyword remark = new Keyword("您的验票信息审核未通过,请到\n\"我的\"-\"我的查验\"查看详情",Constant.color);
		data.put("remark", remark);
		param.put("data", data);
		String jsonContent =  JSON.toJSONString(param);
		String result = sendApprovedData(accessToken,jsonContent);
		JSONObject obj = JSON.parseObject(result);
		Integer errorCode = Integer.parseInt(obj.get("errcode").toString());
		if(errorCode == 42001){
			String weixinTokenResult = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.WEIXINAPPID+"&secret="+Constant.WEIXINAPPSECRET);
			JSONObject weixinTokenJSON = JSON.parseObject(weixinTokenResult);
			String token = weixinTokenJSON.getString("access_token");
			weixinMapper.updateAccessToken(token, System.currentTimeMillis());
			accessToken =  weixinMapper.getWeixinAccessToken();
			result = sendApprovedData(accessToken,jsonContent);
		}
		return result;
	}
}