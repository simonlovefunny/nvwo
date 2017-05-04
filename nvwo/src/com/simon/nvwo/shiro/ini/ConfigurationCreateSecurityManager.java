package com.simon.nvwo.shiro.ini;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ConfigurationCreateSecurityManager {
	
	//测试使用config/shiro-config.ini登录
	@Test
	public void testConfigurationCreate(){
		
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  
		         new IniSecurityManagerFactory("classpath:shiro-config.ini");  
		  
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
		  
		//将SecurityManager设置到SecurityUtils 方便全局使用  
		SecurityUtils.setSecurityManager(securityManager);  
		Subject subject = SecurityUtils.getSubject();  
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		subject.login(token);  
		  
		Assert.assertTrue(subject.isAuthenticated()); 
	}

}
