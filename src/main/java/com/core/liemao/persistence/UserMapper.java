package com.core.liemao.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.core.liemao.domain.Feedback;
import com.core.liemao.domain.Region;
import com.core.liemao.domain.User;
import com.core.liemao.domain.VerificationCode;
import com.core.liemao.persistence.provider.TicketProvider;
import com.core.liemao.persistence.provider.UserProvider;

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
	@Insert("insert into t_user(phone,weixin_id,last_modify_time) value(#{phone},#{weixinId},current_timestamp())")
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
	@Select("select * from t_user where weixin_id = #{weixinId}")
	public User getUserForWeixinId(String weixinId);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@UpdateProvider(type=UserProvider.class,method="updateUserInfo")
	public Integer updateUserInfo(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@SelectProvider(type=UserProvider.class,method="getRegion")
	public List<Region> getRegion(Region region);
	
	/**
	 * 获取用户信息
	 * @param phone
	 * @return
	 */
	@Select("select * from t_user where id = #{id}")
	public User getUserById(Integer id);
	
	/**
	 * 用户添加反馈
	 * @param user
	 * @return
	 */
	@Insert("insert into t_feedback(title,content,user_id) value(#{title},#{content},#{userId})")
	@Options(useGeneratedKeys=true)
	public Integer feedbackAdd(Feedback feedback);
	
	/**
	 * 用户添加列表
	 * @param user
	 * @return
	 */
	@SelectProvider(type=UserProvider.class,method="feedbackList")
	public List<Feedback> feedbackList(Feedback feedback);
	
	/**
	 * 回复用户反馈
	 * @param feedback
	 * @return
	 */
	@Update("update t_feedback set feedback = #{feedback},feedback_time = current_timestamp(),is_read = 2 where id = #{id}")
	public Integer feedbackReply(Feedback feedback);

	/**
	 * 用户反馈详情w
	 * @param feedback
	 * @return
	 */
	@Select("select * from t_feedback where id = #{id}")
	public Feedback feedbackDetail(Feedback feedback);
	
	/**
	 * 用户反馈标记为已读
	 * @param feedback
	 * @return
	 */
	@Update("update t_feedback set is_read = 1 where id = #{id}")
	public Integer feedbackMarkRead(Feedback feedback);
	/**
	 * 系统用户登录
	 * @param user
	 * @return
	 */
	@Select("select * from t_sys_user where user_name = #{userName} and pwd = #{pwd}")
	public User getSysUser(User user);
	
	@Select("select * from t_feedback")
	public List<Feedback> feedbackManager(Feedback feedback);
}
