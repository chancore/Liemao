package com.core.liemao.persistence.provider;

import com.core.liemao.domain.Ticket;

public class TicketProvider {
    
	public String verifyList(Ticket ticket){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("select * from t_ticket where user_id = #{userId} order by create_time desc ");
    	if(ticket.getLimit() != null){
    		buffer.append(" limit #{start},#{limit}");
    	}
    	return buffer.toString();
    }
}