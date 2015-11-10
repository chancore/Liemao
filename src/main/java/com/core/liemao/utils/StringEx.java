package com.core.liemao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 字符串处理工具类
 * @author: xuan.chen
 * @date: 2011-6-6上午10:28:09
 */
public class StringEx {
	/**
	 * 字符串首字母小写
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}
	
	/**
	 * 随机生成字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }
	
	/**
	 * 随机生成数字
	 * @param length
	 * @return
	 */
	public static String getRandomInteger(int length) {
	    String base = "0123456789";
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }
	
	/**
	 * 根据时间格式生成时间
	 * @param formate yyyy-MM-dd 
	 * @return 2015-01-02
	 */
	public static String dateFormate(String formate){
    	java.text.DateFormat format1 = new java.text.SimpleDateFormat(formate);    
		String s = format1.format(new Date());  
		return s;
    }
	
	/**
	 * 生成订单号
	 * @return
	 */
	public static String generateOrderNo(){
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMMddHHmmssSS");  
	    Long time = new Long(System.currentTimeMillis());  
	    String d = format.format(time);
		StringBuffer sbuffer = new StringBuffer();
		sbuffer.append(d);
		sbuffer.append(getRandomInteger(6));
		return sbuffer.toString();
	}
	
	/**
	 * 验证手机号码格式
	 * @param phoneNum
	 * @return
	 */
	public static boolean verificationPhone(String phoneNum){
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0123456789]))\\d{8}$");
	    Matcher matcher = pattern.matcher(phoneNum);
	    return matcher.matches() ;
	}
	
	
	
}
