package com.core.liemao.persistence.provider;

import com.core.liemao.domain.Feedback;
import com.core.liemao.domain.Region;
import com.core.liemao.domain.Ticket;
import com.core.liemao.domain.User;

public class UserProvider {
    
    
	public String updateUserInfo(User user){
		StringBuffer buffer = new StringBuffer();
		buffer.append("update t_user set last_modify_time = current_timestamp()");
		if(user.getName() != null){
		    buffer.append(",name = #{name}");
		}
		if(user.getGender() != null){
		    buffer.append(",gender = #{gender}");
		}
		if(null != user.getEmail()){
		    buffer.append(",email = #{email}");
		}
		if(user.getProvinceId() != null){
		    buffer.append(",province_id = #{provinceId}");
		}
		if(user.getProvinceName() != null){
		    buffer.append(",province_name = #{provinceName}");
		}
		if(user.getCityId() != null){
		    buffer.append(",city_id = #{cityId}");
		}
		if(user.getCityName() != null){
		    buffer.append(",city_name = #{cityName}");
		}
		if(user.getAreaId() != null){
		    buffer.append(",area_id = #{areaId}");
		}
		if(user.getAreaName() != null){
		    buffer.append(",area_name = #{areaName}");
		}
		if(user.getAddress() != null){
		    buffer.append(",address = #{address}");
		}
		buffer.append(" where id = #{id}");
		return buffer.toString();
    }
    
    public String getRegion(Region region){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("select class_id as id,class_name as name, class_type as type ").
    	 append(" from t_system_city where class_type = #{type} and class_parent_id = #{parentId}");
    	return buffer.toString();
    }
    
    public String feedbackList(Feedback feedback){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("select * from t_feedback where user_id = #{userId} order by create_time desc ");
    	if(feedback.getLimit() != null){
    		buffer.append(" limit #{start},#{limit}");
    	}
    	return buffer.toString();
    }
	

}
