package com.siyou.bojun.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 青山
 * @FileName UserBean.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
public class UserBean implements Serializable{
 
	public UserBean(String userName, String pzssword) {
		super();
		this.userName = userName;
		this.pzssword = pzssword;
	}
	private static final long serialVersionUID = 1L;
	
	private int userid;
	private String userName;
	private String pzssword;
	private int credits;
	private String lastip;
	private Date lastVisit;
	private String loginStatus;
	private String privilege;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPzssword() {
		return pzssword;
	}
	public void setPzssword(String pzssword) {
		this.pzssword = pzssword;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserBean(int userid, String userName, String pzssword, int credits, String lastip, Date lastVisit,
			String loginStatus, String privilege) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.pzssword = pzssword;
		this.credits = credits;
		this.lastip = lastip;
		this.lastVisit = lastVisit;
		this.loginStatus = loginStatus;
		this.privilege = privilege;
	}
	public UserBean() {
		super();
	}

}
