package com.core.liemao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.domain.response.ResultObject;
import com.core.liemao.service.TicketService;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:02:25 
 * 类说明 
 */
@Controller
@RequestMapping(value="/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@RequestMapping(value = "/upload_ticket", method = RequestMethod.POST, consumes = "multipart/form-data",
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultObject<Ticket> uploadTicket(TicketReq ticketReq) throws Exception{
		ResultObject<Ticket> result = new ResultObject<Ticket>();
		Ticket ticket = ticketService.updateTicket(ticketReq);
		result.setDomain(ticket);
		return result;
	}
}
