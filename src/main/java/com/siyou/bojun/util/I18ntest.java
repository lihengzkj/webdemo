package com.siyou.bojun.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18ntest {
	public static void main(String []  args){
				//资源包的路径+资源名
				String basename = "com.siyou.bojun.i18n.i18nproperties";
				//设置语言环境
				Locale cn = Locale.CHINA;
				Locale us = Locale.US;
				Locale tw = Locale.TAIWAN;
				
				//根据路径和语言环境加载对应的资源文件
				ResourceBundle resourceCN = ResourceBundle.getBundle(basename, cn);
				ResourceBundle resourceUS = ResourceBundle.getBundle(basename, us);
				ResourceBundle resourceTW = ResourceBundle.getBundle(basename, tw);
				
				String usernameCN = resourceCN.getString("username");
				String passwordCN = resourceCN.getString("password");
				
				String usernameUS = resourceUS.getString("username");
				String passwordUS = resourceUS.getString("password");
				
				String usernameTW = resourceTW.getString("username");
				String passwordTW = resourceTW.getString("password");
				
				System.out.println("中文 >>> "+usernameCN+"  >>>  "+passwordCN);
				System.out.println("英文 >>> "+usernameUS+"  >>>  "+passwordUS);
				System.out.println("繁体 >>> "+usernameTW+"  >>>  "+passwordTW);
	}
}
