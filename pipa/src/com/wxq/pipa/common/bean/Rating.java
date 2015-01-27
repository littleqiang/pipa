/**
 * 
 */
package com.wxq.pipa.common.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * 描述:等级,评价
 */
public class Rating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int max;
	private int numRaters;//评价人数
	private String average;//好评率
	private int min;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getNumRaters() {
		return numRaters;
	}
	public void setNumRaters(int numRaters) {
		this.numRaters = numRaters;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	

}
