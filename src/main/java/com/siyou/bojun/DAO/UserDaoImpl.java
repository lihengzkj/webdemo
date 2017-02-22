package com.siyou.bojun.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.siyou.bojun.bean.PageBean;
import com.siyou.bojun.bean.UserBean;

/**
 * 
 * @author 青山
 * @FileName UserDaoImpl.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
@Repository  //通过spring注解顶一个DAO 
public class UserDaoImpl{
	
	private static Logger  logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired  //自动注入JdbcTemplate bean
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据用户名和密码查询用户的个数
	 * @param username
	 * @param password
	 * @return UserBean
	 */
	public UserBean getMatchCount(String username,String password) throws Exception{
		
		String sql = "select user_id,user_name,credits,login_status,privilege from t_user"
				+ " where user_name=? and password=?";
		logger.info("query sql:"+sql);
		final UserBean user = new UserBean();
		
		jdbcTemplate.query(sql, new Object[]{username ,password }, new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				user.setUserid(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setCredits(rs.getInt("credits"));
				user.setLoginStatus(rs.getString("login_status"));
				user.setPrivilege(rs.getString("privilege"));
			}});
		
		return user;
	} 
	
	public UserBean getUserByUserID(String userid) {
		
		String sql = "select user_id,user_name,credits,login_status,privilege from t_user"
				+ " where user_id= ?";
		logger.info("query sql:"+sql);
		final UserBean user = new UserBean();
		
		jdbcTemplate.query(sql, new Object[]{userid }, new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				user.setUserid(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setCredits(rs.getInt("credits"));
				user.setLoginStatus(rs.getString("login_status"));
				user.setPrivilege(rs.getString("privilege"));
			}});
		
		return user;
	} 
	
	
	/**
	 * 获取制定语言环境的所有新闻
	 * @param language
	 * @return
	 */
	public PageBean<UserBean> getAllUser(){
		String tableName = "t_user";
		String sql = "select user_id,user_name,credits,password,last_visit,last_ip,login_status,privilege from "+tableName;
		logger.info("getAllNews >> sql:"+sql);
		PageBean<UserBean> page = new PageBean<UserBean>();
		List<UserBean> result = jdbcTemplate.query(sql, new RowMapper<UserBean>(){

			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean user = new UserBean();

				user.setUserid(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setCredits(rs.getInt("credits"));
				user.setPzssword(rs.getString("password"));
				user.setLastVisit(rs.getDate("last_visit"));
				user.setLastip(rs.getString("last_ip"));
				user.setLoginStatus(rs.getString("login_status"));
				user.setPrivilege(rs.getString("privilege"));
				
				return user;
			}});
		
		page.setAllRecords(result.size());
		page.setPageData(result);
		
		return page;
	}
	
	
	/**
	 * 根据用户名检查用户是否存在
	 * @param username
	 * @return
	 */
	public boolean checkIfUserNameExist(String username){
		String sql = "select count(1) from t_user where user_name = ?";  
		Integer result = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
		if(result>0){
			return true;
		}
		return false;
	}
	/**
	 * 添加一个用户
	 * @param user
	 */
	public void addUser(UserBean user){
		String sql = "insert into t_user(user_name,credits,password,login_status,privilege)values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{user.getUserName(),
												user.getCredits()==0?10:user.getCredits(),
														user.getPzssword()==null?user.getUserName():user.getPzssword(),
																user.getLoginStatus()==null?"F":user.getLoginStatus(),
																		user.getPrivilege()});
		logger.info("Add user >> id:"+user.getUserid()+" username:"+user.getUserName());
	}
	/**
	 * 删除一个用户
	 * @param userid
	 */
	public void deleteUser(int userid){
		String sql = "delete from t_user where user_id = ?";
		jdbcTemplate.update(sql, new Object[]{userid});
		logger.info("Delete user >> userid:"+userid);
	}
	/**
	 * 修改一个用户
	 * @param user
	 */
	public void updateUserInfo(UserBean user){
		String sql = this.getSQLforUserBean(user);
		logger.info("update sql:"+sql);
		
		int result = jdbcTemplate.update(sql, this.getParamters(user));
		
		logger.info("update count:"+result);
	}
	
	public Object[] getParamters(UserBean user) {
		Object [] params = new Object[5];
		int paraCnt = 0;
		if(StringUtils.isNotBlank(user.getUserName())){
			params[0] = user.getUserName();
			paraCnt++;
		}
		if(StringUtils.isNotBlank(user.getPzssword())){
			params[1] = user.getPzssword();
			paraCnt++;
		}
		if(StringUtils.isNotBlank(user.getLoginStatus())){
			params[2] = user.getLoginStatus();
			paraCnt++;
		}
		if(StringUtils.isNotBlank(user.getPrivilege())){
			params[3] = user.getPrivilege();
			paraCnt++;
		}
		if(user.getCredits()>0){
			params[4] = user.getCredits();
			paraCnt++;
		}
		Object [] result = new Object[paraCnt+1];
		for(int i =0;i<params.length;i++){
			Object obj = params[i];
			if(obj!=null){
				for(int j =0;j<result.length;j++){
					if(result[j]==null){
						result[j] = obj;
						break;
					}
				}
			}
		}
		result[paraCnt] = user.getUserid();
		
		
		
		logger.info("getParamters >> "+Arrays.toString(result));
		return result;
	}

	public String getSQLforUserBean(UserBean user) {
		String sql = "update t_user set ";
		boolean ifNeedComma = false;
		if(StringUtils.isNotBlank(user.getUserName())){
			sql += " user_name = ? ";
			ifNeedComma = true;
		}
		if(StringUtils.isNotBlank(user.getPzssword())){
			if(ifNeedComma){
				sql += " , password = ? ";
			}else{
				sql += " password = ? ";
			}
			ifNeedComma = true;
		}
		if(StringUtils.isNotBlank(user.getLoginStatus())){
			if(ifNeedComma){
				sql += " , login_status = ? ";
			}else{
				sql += " login_status = ? ";
			}
			ifNeedComma = true;
		}
		if(StringUtils.isNotBlank(user.getPrivilege())){
			if(ifNeedComma){
				sql += " , privilege = ? ";
			}else{
				sql += " privilege = ? ";
			}
			ifNeedComma = true;
		}
		if(user.getCredits()>0){
			if(ifNeedComma){
				sql += " , credits = ? ";
			}else{
				sql += " credits = ? ";
			}
			ifNeedComma = true;
		}
		
		sql += " where user_id = ? ";
		
		return sql;
	}

	/**
	 * create table t_user(
		user_id int auto_increment primary key,
		user_name varchar(30),
		credits  int,
		password varchar(32) not null,
		last_visit datetime,
		last_ip  varchar(23),
		login_status varchar(1),
		privilege varchar(10)
		);
	 */
	 
}
