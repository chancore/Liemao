package com.core.liemao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DateUtils {

	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	/**
	* 日期转换成字符串
	* @param date 
	* @return str
	*/
	public static String DateToStr(Date date,String format) {
	  
	   SimpleDateFormat sdf = new SimpleDateFormat(format);
	   String str = sdf.format(date);
	   return str;
	}
	
	/**
	* 日期转换成字符串
	* @param date 
	* @return str
	*/
	public static String TimestampToStr(Long befoerTime) {
		String format = "yyyy-MM-dd :HH:mm:ss";
		Date befoerDate = new Date(befoerTime);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String befoerStr = sdf.format(befoerDate);
		return befoerStr;
	}
	
	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date StrToDate(String str,String format) {
	  
	   SimpleDateFormat sdf = new SimpleDateFormat(format);
	   Date date = null;
	   try {
	    date = sdf.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}
	/**
	 * 获取星期几
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 传入星期几，根据当前时间得到星期几的日期
	 * @param week
	 * @return
	 */
	public static String getDayForWeek(int week){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		Calendar calendar=Calendar.getInstance(Locale.CHINA);
		//当前时间，貌似多余，其实是为了所有可能的系统一致
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date date = calendar.getTime();
//		Date toDate = org.apache.commons.lang.time.DateUtils.addDays(date, dayc);
		String dd  = sdf.format(date);
		return dd;
	}

	/**
	 * 获取系统当前时间 格式 yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrentTime2StringBySec(){
		Date theTime = new Date(System.currentTimeMillis());
		return DateToStr(theTime, "yyyyMMddHHmmss");
	}
	
}