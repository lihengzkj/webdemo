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
@Controller  //注册成为一个springMVC的controller  
public class LoginController {
	private static String defaultLanguage = Language.CHINESE;
	
	@Autowired
	private UserDaoImpl userdao;
	
	//处理index.html的请求
	@RequestMapping(value="/control/index.html")
	public String loginPage(){
		return "control/login";
	}
	
	@RequestMapping(value="/control/editor.html")
	public String toEditorPage(){
		return "control/editor";
	}
	
	//处理loginCheck.html的请求
	@RequestMapping(value="/control/main.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
		try {
			/*UserBean user = userService.loginService(new UserBean(loginCommand.getUsername(),loginCommand.getPassword()));
			 
			if(user.getUserid()==0){ 
				return new ModelAndView("login","error","用户名或者密码错误！");
			}else{
				request.getSession().setAttribute("user", user);
				return new ModelAndView("control/main");
			}*/
			UserBean user = new UserBean();
			user.setUserName(loginCommand.getUsername());
			request.getSession().setAttribute("user", user);
			return new ModelAndView("control/main");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("control/login","error","代码报错！"+e.getMessage()); 
		}
	}
	@RequestMapping(value="/control/editorCheck.html")
	public  ModelAndView checkEditorContent(HttpServletRequest request, LoginCommand loginCommand){
		
		return new ModelAndView("main"); 
	}
	
	
	@RequestMapping(value="/views/aboutuser.html")
	public String toTeampMainPage(WebRequest request){
		String language = request.getParameter("language");
		if(StringUtils.isBlank(language)){
			language = defaultLanguage;
		}
		request.setAttribute("language", language, WebRequest.SCOPE_REQUEST);
		
		PageBean<UserBean> page = userdao.getAllUser(language);
		
		request.setAttribute("page", page, WebRequest.SCOPE_REQUEST);
		
		return "views/aboutuser";
	}
	
}
