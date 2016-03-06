package com.spring.test;

import org.junit.Test;

import com.spring.bean.User;
import com.spring.service.UserService;
import com.spring.utils.ApplicationContext;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase{
//
//	//测试添加用户的方法
//	@Test
//	public void testAdd() throws Exception {
//		//创建Spring容器
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		
//		//获取userService实例
//		UserService service = (UserService)ctx.getBean("userService");
//		User user = new User();
//		
//		user.setUsername("jack");
//		user.setPassword("123456");
//		user.setPhoneNum("18867812332");
//		user.setAddress("beijing");
//		
//		int flag = service.addUser(user);
//		System.out.println(flag);
//		ctx.destroy();
//	}
	
//	//测试删除用户的方法
//	@Test
//	public void testDelete() throws Exception {
//		//创建Spring容器
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//				
//		//获取userService实例
//		UserService service = (UserService)ctx.getBean("userService");
//		int flag = service.delUserById(1);
//		System.out.println(flag);
//		ctx.destroy();
//	}
//	
	
//	//测试查找单个用户的方法
//	@Test
//	public void testFindById() throws Exception {
//		//创建Spring容器
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//				
//		//获取userService实例
//		UserService service = (UserService)ctx.getBean("userService");
//		
//		User user = service.findUserById(2);
//		System.out.println(user.getUsername());
//		ctx.destroy();
//	}

//	//测试查找所有用户的方法
//	@Test
//	public void testFindUsers() throws Exception {
//		//创建Spring容器
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//				
//		//获取userService实例
//		UserService service = (UserService)ctx.getBean("userService");
//		
//		List<User> list = service.findUser();
//		System.out.println("用户数:" + list.size());
//		ctx.destroy();
//	}
	
	//测试更新用户的方法
	@Test
	public void testUpdate() throws Exception {
		
		UserService service = ApplicationContext.getService();
		
		User user = service.findUserById(2);
		user.setUsername("hanwen");
		int flag = service.updateUser(user);
		System.out.println("更新的记录数" + flag);
		
		User user2 = service.findUserById(2);
		ApplicationContext.Destroy();
	}
	

}
