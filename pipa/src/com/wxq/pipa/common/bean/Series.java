/**
 * 
 */
package com.wxq.pipa.common.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * 描述:系列
 */
public class Series implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
