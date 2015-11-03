package com.core.liemao.service;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.request.TicketReq;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:57:16 
 * 类说明 
 */
public interface TicketService {
	/**
	 * @param ticketReq
	 * @return
	 */
	public Ticket updateTicket(TicketReq ticketReq) throws Exception;

}
