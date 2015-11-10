package com.core.liemao.service;

import java.util.List;

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
	
	/**
	 * 审核验票
	 * @param ticketReq
	 * @return
	 */
	public Ticket verifyTicket(Ticket ticketReq) throws Exception;
	
	/**
	 * 验票列表
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	public List<Ticket> verifyList(Ticket ticketReq) throws Exception;
	/**
	 * 标记为已读
	 * @param ticketReq
	 * @throws Exception
	 */
	public void markRead(Ticket ticketReq) throws Exception;
	/**
	 * 详情
	 * @param ticketReq
	 * @throws Exception
	 */
	public Ticket detail(Ticket ticketReq) throws Exception;
	
	
	public List<TicketReq> verifyListForView(TicketReq ticketReq);
	

}
