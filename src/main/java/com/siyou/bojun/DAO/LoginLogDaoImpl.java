package com.siyou.bojun.DAO; 

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.siyou.bojun.bean.LoginLogBean;
import com.siyou.bojun.bean.UserBean;
import com.siyou.bojun.util.CommUtil;

/**
 * 
 * @author 青山
 * @FileName LoginLogDaoImpl.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
@Repository 
public class LoginLogDaoImpl {
	
	private static Logger  logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 插入用户登录的信息
	 */
	public void insertLoginLog(LoginLogBean loginLog) {
		String sql = "insert into t_login_log (user_id,ip,login_datatime) values (?,?,?)";
		
		logger.info("ParameterUser: "+loginLog.getUserid()+" loginTime: "+CommUtil.getFormatDate(loginLog.getLoginDate())+" ipaddress: "+loginLog.getIp());
		jdbcTemplate.update(sql, new Object[]{loginLog.getUserid(),loginLog.getIp(),CommUtil.getFormatDate(loginLog.getLoginDate())});
		
	}
	
	public static void main(String [] args){
		UserBean user = new UserBean();
		System.out.println(user.getUserid());
	}

}
