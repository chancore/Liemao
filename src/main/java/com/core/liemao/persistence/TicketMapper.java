package com.core.liemao.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.core.liemao.domain.Ticket;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午10:37:46 
 * 类说明 
 */
public interface TicketMapper {

	@Insert("insert into t_ticket(front_img,back_img,user_id) value(#{frontImg},#{backImg},#{userId})")
	@Options(useGeneratedKeys=true)
	public Integer addTicket(Ticket ticket);
}
