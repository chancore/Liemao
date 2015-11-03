package com.core.liemao.domain.request;

import org.springframework.web.multipart.MultipartFile;

import com.core.liemao.domain.Ticket;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午9:49:48 
 * 类说明 
 */
public class TicketReq extends Ticket{

	private MultipartFile frontImgFile;
	private MultipartFile backImgFile;
	/**
	 * @return the frontImgFile
	 */
	public MultipartFile getFrontImgFile() {
		return frontImgFile;
	}
	/**
	 * @param frontImgFile the frontImgFile to set
	 */
	public void setFrontImgFile(MultipartFile frontImgFile) {
		this.frontImgFile = frontImgFile;
	}
	/**
	 * @return the backImgFile
	 */
	public MultipartFile getBackImgFile() {
		return backImgFile;
	}
	/**
	 * @param backImgFile the backImgFile to set
	 */
	public void setBackImgFile(MultipartFile backImgFile) {
		this.backImgFile = backImgFile;
	}
	
}
