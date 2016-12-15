package com.siyou.bojun.command;
/**
 * 
 * @author 青山
 * @FileName LoginCommand.java
 * @Date Oct 21, 2016
 * @Desc
 *
 */
public class LoginCommand {
	private String username;
	private String password;
	public String getUsername() {
		System.out.println("get user name:"+username);
		return username;
	}
	public void setUsername(String username) {
		System.out.println("set user name:"+username);
		this.username = username;
	}
	public String getPassword() {
		System.out.println("get user pwd:"+password);
		return password;
	}
	public void setPassword(String password) {
		System.out.println("set user pwd:"+password);
		this.password = password;
	}
	
}
