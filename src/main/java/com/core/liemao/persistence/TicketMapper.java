package com.core.liemao.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.request.TicketReq;
import com.core.liemao.persistence.provider.TicketProvider;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月28日 下午10:37:46 
 * 类说明 
 */
public interface TicketMapper {

	@Insert("insert into t_ticket(front_img,back_img,user_id) value(#{frontImg},#{backImg},#{userId})")
	@Options(useGeneratedKeys=true)
	public Integer addTicket(Ticket ticket);
	
	@Update("update t_ticket set verify_result = #{verifyResult} ,reason = #{reason} ,is_read = 2,verify_time = current_timestamp() where id = #{id}")
	public Integer verifyTicket(Ticket ticket);
	
	@SelectProvider(type=TicketProvider.class,method="verifyList")
	public List<Ticket> verifyList(Ticket ticket);
	
	@SelectProvider(type=TicketProvider.class,method="verifyListForView")
	public List<TicketReq> verifyListForView(TicketReq ticket);
	/**
	 * 标记为已读
	 * @param ticket
	 * @return
	 */
	@Update("update t_ticket set is_read = 1 where id = #{id}")
	public Integer markRead(Ticket ticket);
	/**
	 * 详情
	 * @param ticket
	 * @return
	 */
	@Select("select * from t_ticket where id = #{id}")
	public Ticket detail(Ticket ticket);
}
