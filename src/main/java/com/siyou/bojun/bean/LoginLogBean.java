package com.siyou.bojun.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 青山
 * @FileName LoginLogBean.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
public class LoginLogBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private int loginLogId;
	private int userid;
	private String ip;
	private Date loginDate;
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LoginLogBean() {
		super();
	}
	public LoginLogBean(int userid, String ip, Date loginDate) {
		super(); 
		this.userid = userid;
		this.ip = ip;
		this.loginDate = loginDate;
	}
	
	
	
}
