package com.core.liemao.service;

import com.core.liemao.domain.Keyword;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月22日 下午9:58:04 
 * 类说明 
 */
public interface WeixinService {

	public String sendBatchMsg(Keyword keyword) throws Exception;
	
	/**
	 * 审核通过发送消息
	 * @return
	 */
	public String sendApproved(String openId);
	/**
	 * 审核未通知发送消息
	 * @return
	 */
	public String sendUnapprove(String openId,String reason);
}
