package com.core.liemao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.domain.response.Result;
import com.core.liemao.domain.response.ResultList;
import com.core.liemao.domain.response.ResultObject;
import com.core.liemao.service.TicketService;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:02:25 
 * 类说明 
 */
@Controller
@RequestMapping(value="/ticket",produces = "application/json;charset=UTF-8")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	/**
	 * 上传验票
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload_ticket", method = RequestMethod.POST, consumes = "multipart/form-data")
	public String uploadTicket(TicketReq ticketReq) throws Exception{
		ResultObject<Ticket> result = new ResultObject<Ticket>();
		Ticket ticket = ticketService.updateTicket(ticketReq);
		result.setDomain(ticket);
		return "tickect/upload_success";
	}
	/**
	 * 审核验票
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/verify_ticket")
	@ResponseBody
	public ResultObject<Ticket> verifyTicket(TicketReq ticketReq) throws Exception{
		ResultObject<Ticket> result = new ResultObject<Ticket>();
		Ticket ticket = ticketService.verifyTicket(ticketReq);
		result.setDomain(ticket);
		return result;
	}
	/**
	 * 审核列表
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/verify_list")
	@ResponseBody
	public ResultList<Ticket> verifyList(TicketReq ticketReq) throws Exception{
		ResultList<Ticket> result = new ResultList<Ticket>();
		result.setItemList(ticketService.verifyList(ticketReq));
		return result;
	}
	/**
	 * 标记为已读
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mark_read")
	@ResponseBody
	public Result markRead(TicketReq ticketReq) throws Exception{
		ticketService.markRead(ticketReq);
		return new Result();
	}
	
	/**
	 * 标记为已读
	 * @param ticketReq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail")
	@ResponseBody
	public ResultObject<Ticket> detail(Ticket ticketReq) throws Exception{
		ResultObject<Ticket> result = new ResultObject<Ticket>();
		result.setDomain(ticketService.detail(ticketReq));
		return result;
	}
	
	@RequestMapping("/manager")
	public String ticketManager(Map<String, Object> model,TicketReq ticketReq) throws Exception{
		model.put("ticketReq", ticketReq);
		List<TicketReq> list = ticketService.verifyListForView(ticketReq);
		model.put("list", list);
		return "frame";
	}
	
}
