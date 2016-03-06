package com.spring.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.UserService;

public class ApplicationContext {
	
	private final static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	public static UserService getService() {
		return (UserService) ctx.getBean("userService");
	}
	
	public static void Destroy() {
		ctx.destroy();
	}
	
}
