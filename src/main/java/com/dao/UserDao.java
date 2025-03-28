package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt; // singleton

	// singleton design pattern
	public void addUser(UserBean userBean) {
		// insert update delete
		stmt.update("insert into users (firstName,lastName,email,password) values (?,?,?,?)", userBean.getFirstName(),
				userBean.getLastName(), userBean.getEmail(), userBean.getPassword());
	}

	// select
	// query -> n record 1+
	// queryForObject -> exact 1
	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<>(UserBean.class));
		return users;
	}

	public void deleteByUserId(Integer userId) {
		stmt.update("delete from users where userId = ?", userId);
	}

	public UserBean getByUserId(Integer userId) {
		try {
			UserBean user = stmt.queryForObject("select * from users where userId = ?",
					new BeanPropertyRowMapper<>(UserBean.class), new Object[] { userId });

			 
 			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
//UserDao -> depen -> JdbcTemplate -> Depen -> Connection -> credentials  

//IoC -> start -> dep inject -> DI ->
//@Autowired 
