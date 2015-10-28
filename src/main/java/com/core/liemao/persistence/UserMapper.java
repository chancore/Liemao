package com.core.liemao.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.core.liemao.domain.User;
import com.core.liemao.domain.VerificationCode;

/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月25日 下午4:42:36 
 * 类说明 
 */
public interface UserMapper {
	
	@Insert("insert into t_verification_code(phone,code) value(#{phone},#{code})")
	public Integer addVerificationCode(VerificationCode verificationCode);
	
	/**
	 * 校验短信验证码,30分钟内有效
	 * @param verificationCode
	 * @return
	 */
	@Select("select * from t_verification_code where phone = #{phone} and code = #{code} and "
			+ " create_time >= DATE_SUB(NOW(),INTERVAL 30 MINUTE)")
	public VerificationCode verificationCode(VerificationCode verificationCode);

	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@Insert("insert into t_user(phone,weixin_id) value(#{phone},#{weixinId})")
	@Options(useGeneratedKeys=true)
	public Integer registerUser(User user);
	
	/**
	 * 通过手机号码查询用户
	 * @param phone
	 * @return
	 */
	@Select("select * from t_user where phone = #{phone}")
	public User getUserForPhone(String phone);
	
	/**
	 * 通过微信ID查询用户是否已经存在 
	 * @param phone
	 * @return
	 */
	@Select("select * from t_user where phone = #{weixinId}")
	public User getUserForWeixinId(String weixinId);
}
