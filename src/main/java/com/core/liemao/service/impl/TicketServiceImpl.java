package com.core.liemao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.User;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.exception.ServerException;
import com.core.liemao.persistence.TicketMapper;
import com.core.liemao.persistence.UserMapper;
import com.core.liemao.service.TicketService;
import com.core.liemao.service.WeixinService;
import com.core.liemao.utils.FileUtils;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:58:29 
 * 类说明 
 */
@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private FileUtils fileUtils;
	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private WeixinService weixinService;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Ticket updateTicket(TicketReq ticketReq) throws Exception{
		MultipartFile frontImgFile = ticketReq.getFrontImgFile();
		MultipartFile backImgFile = ticketReq.getBackImgFile();
		
		if(null == frontImgFile ){
			throw new ServerException(ErrorConstant.FRONT_IMG_NOT_NULL.getErrorCode(), ErrorConstant.FRONT_IMG_NOT_NULL.getErrorMessageToUser());
		}
		if(null == backImgFile ){
			throw new ServerException(ErrorConstant.BACK_IMG_NOT_NULL.getErrorCode(), ErrorConstant.BACK_IMG_NOT_NULL.getErrorMessageToUser());
		}
		if(frontImgFile.getSize() > 5121000){
			throw new ServerException(ErrorConstant.FRONT_IMG_NOT_NULL.getErrorCode(), "正面图片大于5M,请重新选择.");
		}
		if(backImgFile.getSize() > 5121000){
			throw new ServerException(ErrorConstant.FRONT_IMG_NOT_NULL.getErrorCode(), "背面图片大于5M,请重新选择.");
		}
		if(ticketReq.getUserId() == null || ticketReq.getUserId() == 0){
			throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
		}
		String frontImgPath = fileUtils.fileUpload(frontImgFile);
		if(null == frontImgPath || frontImgPath.equals("")){
			throw new ServerException(ErrorConstant.FILE_SAVE_FAIL.getErrorCode(), ErrorConstant.FILE_SAVE_FAIL.getErrorMessageToUser());
		}
		String backImgPath = fileUtils.fileUpload(backImgFile);
		Ticket ticket = new Ticket();
		ticket.setUserId(ticketReq.getUserId());
		ticket.setFrontImg(frontImgPath);
		ticket.setBackImg(backImgPath);
		ticketMapper.addTicket(ticket);
		return ticket;
	}

	@Override
	public Ticket verifyTicket(Ticket ticketReq) throws Exception {
		if(ticketReq.getId() == null){
			throw new ServerException(ErrorConstant.TICKET_ID_NOT_NULL.getErrorCode(), ErrorConstant.TICKET_ID_NOT_NULL.getErrorMessageToUser());
		}
		if(ticketReq.getVerifyResult() == null){
			throw new ServerException(ErrorConstant.TICKET_VERIFY_RESULT_NOT_NULL.getErrorCode(), ErrorConstant.TICKET_VERIFY_RESULT_NOT_NULL.getErrorMessageToUser());
		}
		if(ticketReq.getVerifyResult() == 2 && ticketReq.getReason() == null){
			throw new ServerException(ErrorConstant.TICKET_VERIFY_RESULT_FALSE_ROASON_NULL.getErrorCode(), ErrorConstant.TICKET_VERIFY_RESULT_FALSE_ROASON_NULL.getErrorMessageToUser());
		}
		ticketMapper.verifyTicket(ticketReq);
		User user = userMapper.getUserByTicketId(ticketReq.getId());
		String openId = user.getWeixinId();
		//通过
		if(ticketReq.getVerifyResult() == 1){
			
			weixinService.sendApproved(openId);
		}
		//未通过
		if(ticketReq.getVerifyResult() == 2){
			weixinService.sendUnapprove(openId, ticketReq.getReason());
		}
		return ticketReq;
	}

	@Override
	public List<Ticket> verifyList(Ticket ticketReq) throws Exception {
		if(ticketReq.getUserId() == null){
			throw new ServerException(ErrorConstant.USER_ID_NOT_NULL.getErrorCode(), ErrorConstant.USER_ID_NOT_NULL.getErrorMessageToUser());
		}
		return ticketMapper.verifyList(ticketReq);
	}

	@Override
	public void markRead(Ticket ticketReq) throws Exception {
		ticketMapper.markRead(ticketReq);
	}

	@Override
	public Ticket detail(Ticket ticketReq) throws Exception {
		if(ticketReq.getId() == null){
			throw new ServerException(ErrorConstant.TICKET_ID_NOT_NULL.getErrorCode(), ErrorConstant.TICKET_ID_NOT_NULL.getErrorMessageToUser());
		}
		return ticketMapper.detail(ticketReq);
	}
	
	@Override
	public List<TicketReq> verifyListForView(TicketReq ticketReq)  {
		
		return ticketMapper.verifyListForView(ticketReq);
	}
}