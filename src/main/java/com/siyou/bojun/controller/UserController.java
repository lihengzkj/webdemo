package com.siyou.bojun.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.siyou.bojun.DAO.UserDaoImpl;
import com.siyou.bojun.bean.PageBean;
import com.siyou.bojun.bean.UserBean;
import com.siyou.bojun.command.LoginCommand;
import com.siyou.bojun.util.Language;

/**
 * 
 * @author 青山
 * @FileName LoginController.java
 * @Date Oct 21, 2016
 * @Desc
 *
 */
@Controller  
public class UserController { 
	
	@Autowired
	private UserDaoImpl userdao;
	
	@RequestMapping(value="/views/updateUserPage.html")
	public String goToUpdatePage(WebRequest request){
		String userid = request.getParameter("userid");
		
		UserBean user = userdao.getUserByUserID(userid);
		
		request.setAttribute("user", user, WebRequest.SCOPE_REQUEST);
		
		return "views/viewuser";
	}
	
	@RequestMapping(value="/views/addUserPage.html")
	public String goToAddUserPage(WebRequest request){  
		return "views/adduser";
	}
	
	@RequestMapping(value="/views/addUserLogic.html")
	public String goToAddUserLogic(WebRequest request){  
		
		String username = request.getParameter("userName");
		String privilege =  request.getParameter("privilege");
		UserBean user = new UserBean(); 
		user.setUserName(username);
		user.setPrivilege(privilege); 
		
		userdao.addUser(user);
		
		PageBean<UserBean> page = userdao.getAllUser();
		
		request.setAttribute("page", page, WebRequest.SCOPE_REQUEST);
		return "views/listuser";
	}
	
	@RequestMapping(value="/views/deleteUser.html")
	public String deleteUser(WebRequest request){  
		String userid = request.getParameter("userid");
		userdao.deleteUser(Integer.parseInt(userid));
		PageBean<UserBean> page = userdao.getAllUser(); 
		request.setAttribute("page", page, WebRequest.SCOPE_REQUEST);
		return "views/listuser";
	}
	
	
	@RequestMapping(value="/views/updateUserLogic.html")
	public String UpdateUserLogic(WebRequest request){
		
		String username = request.getParameter("userName");
		String privilege =  request.getParameter("privilege");
		String userid = request.getParameter("userid");
		
		UserBean user = new UserBean();
		user.setUserid(Integer.parseInt(userid));
		user.setUserName(username);
		user.setPrivilege(privilege); 
		
		userdao.updateUserInfo(user);
		
		PageBean<UserBean> page = userdao.getAllUser();
		
		request.setAttribute("page", page, WebRequest.SCOPE_REQUEST);
		
		return "views/listuser";
		
	}
	
	
	@RequestMapping(value="/views/index.html")
	public String toTeampMainPage(WebRequest request){
		
		PageBean<UserBean> page = userdao.getAllUser();
		
		request.setAttribute("page", page, WebRequest.SCOPE_REQUEST);
		
		return "views/listuser";
	}
	
}
