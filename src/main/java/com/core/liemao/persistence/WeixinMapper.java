package com.core.liemao.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.core.liemao.domain.WeixinAccessToken;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月25日 下午4:42:36 
 * 类说明 
 */
public interface WeixinMapper {
	
	@Select("select * from t_access limit 1")
	public WeixinAccessToken getWeixinAccessToken();
	
	@Update("update t_access set accesstoken = #{token}, creattime = #{updateTime}")
	public Integer updateAccessToken(@Param("token") String token,@Param("updateTime") Long updateTime);
	
}
