package com.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.spring.bean.User;
import com.spring.dao.UserDAO;

public class UserService implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//实现根据id查询用户的方法
	@Override
	public User findUserById(int id) {
		
		String sql = "select * from user where id = ?";
		final User user = new User();
		final Object[] params = new Object[] {id};
		
		jdbcTemplate.query(sql, params, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//向user对象中添加各个属性
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setAddress(rs.getString("address"));
			}
		});
		
		
		return user;
	}

	//实现查找所有用户
	@Override
	public List<User> findUser() {
		
		String sql = "select * from user";
		List list = jdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int delUserById(int id) {
		String  sql = "delete from user where id = ?";
		Object[] params = new Object[] {id};
		int flag = jdbcTemplate.update(sql, params);
		return flag;
	}

	
	//实现添加用户的方法
	@Override
	public int addUser(User user) {
		
		String sql = "insert into user (username, password, phoneNum, address) values(?, ?, ?, ?)";
		Object[] params = new Object[] {user.getUsername(), user.getPassword(), user.getPhoneNum(), user.getAddress()};
		
		int flag = jdbcTemplate.update(sql, params);
		
		return flag;
		
	}

    //实现更新用户的方法
	@Override
	public int updateUser(User user) {
		String sql = "update user set username = ?, password = ?, phoneNum = ?, address = ? where id = ?";
		
		Object[] params = new Object[] {user.getUsername(), user.getPassword(), user.getPhoneNum(), user.getAddress(), user.getId()};
		
		int flag = jdbcTemplate.update(sql, params);
		
		return flag;
	}

}
