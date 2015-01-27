/**
 * 
 */
package com.wxq.pipa.common.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * 描述:标签
 */
public class Tags implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;//数量
	private String name;//
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
