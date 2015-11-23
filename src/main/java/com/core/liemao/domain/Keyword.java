package com.core.liemao.domain;
/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年11月23日 下午6:58:02 
 * 类说明 
 */
public class Keyword {

	private String value;
	private String color;
	public Keyword(String value, String color) {
		this.value = value;
		this.color = color;
	}
	public Keyword() {
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
