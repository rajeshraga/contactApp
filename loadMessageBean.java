package com.contactApp.beans;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class loadMessageBean implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	@Autowired HttpSession session;
	private  ApplicationContext ctx;
	private String beanName;
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("here in bean created");
		
		
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		this.beanName = arg0;
		System.out.println(this.beanName + " has been initialized");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = arg0;
	}
	
	
}
