package com.core.liemao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.exception.ServerException;
import com.core.liemao.persistence.TicketMapper;
import com.core.liemao.service.TicketService;
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

}
