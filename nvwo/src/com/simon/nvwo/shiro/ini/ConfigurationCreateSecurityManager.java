package com.simon.nvwo.shiro.ini;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ConfigurationCreateSecurityManager {
	
	//����ʹ��config/shiro-config.ini��¼
	@Test
	public void testConfigurationCreate(){
		
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  
		         new IniSecurityManagerFactory("classpath:shiro-config.ini");  
		  
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
		  
		//��SecurityManager���õ�SecurityUtils ����ȫ��ʹ��  
		SecurityUtils.setSecurityManager(securityManager);  
		Subject subject = SecurityUtils.getSubject();  
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		subject.login(token);  
		  
		Assert.assertTrue(subject.isAuthenticated()); 
	}

}
