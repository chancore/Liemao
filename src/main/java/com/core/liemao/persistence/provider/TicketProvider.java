package com.core.liemao.persistence.provider;

import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.request.TicketReq;

public class TicketProvider {
    
	public String verifyList(Ticket ticket){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("select * from t_ticket where 1 = 1 ");
    	if(ticket.getUserId() != null){
    		buffer.append(" and user_id = #{userId}");
    	}
    	if(ticket.getVerifyResult() != null){
    		buffer.append(" and verify_result = #{verifyResult}");
    	}
    	buffer.append(" order by create_time desc ");
    	if(ticket.getLimit() != null){
    		buffer.append(" limit #{start},#{limit}");
    	}
    	return buffer.toString();
    }
	public String verifyListForView(TicketReq ticket){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("select a.*,b.phone from t_ticket a,t_user b where a.user_id = b.id ");
    	if(ticket.getPhone() != null && !ticket.getPhone().trim().isEmpty()){
    		buffer.append(" and b.phone = #{phone}");
    	}
    	if(ticket.getVerifyResult() != null){
    		buffer.append(" and verify_result = #{verifyResult}");
    	}
    	buffer.append(" order by create_time desc ");
    	if(ticket.getLimit() != null){
    		buffer.append(" limit #{start},#{limit}");
    	}
    	return buffer.toString();
    }
}