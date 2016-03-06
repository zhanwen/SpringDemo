package com.spring.dao;

import java.util.List;

import com.spring.bean.User;

public interface UserDAO {
	
	//根据id查找用户
	public User findUserById(int id);
	
	//查询所有用户
	public List<User> findUser();
	
	//根据id删除用户
	public int delUserById(int id);
	
	//添加用户
	public int addUser(User user);
	
	//更新用户
	public int updateUser(User user);
	
}
