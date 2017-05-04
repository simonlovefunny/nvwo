package com.simon.nvwo.shiro.ini;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;

public class NonConfigurationCreateSecurityManager {
	
	//��ʹ��ini�����ļ�����config/shiro-config.ini ����һ����Ч��
	@Test
	public void testNonConfigurationCreate() {
		
		DefaultSecurityManager securityManager = new DefaultSecurityManager();  
		//����authenticator  
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator(); 
		//��֤���ԣ�����һ���ɹ�
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());  
		securityManager.setAuthenticator(authenticator);  
		  
		//����authorizer  
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();  
		authorizer.setPermissionResolver(new WildcardPermissionResolver());  
		securityManager.setAuthorizer(authorizer);  
		  
		//����Realm  
		DruidDataSource ds = new DruidDataSource();  
		ds.setDriverClassName("com.mysql.jdbc.Driver");  
		ds.setUrl("jdbc:mysql://localhost:3306/shiro");  
		ds.setUsername("root");  
		ds.setPassword("root");  
		  
		JdbcRealm jdbcRealm = new JdbcRealm();  
		jdbcRealm.setDataSource(ds);  
		jdbcRealm.setPermissionsLookupEnabled(true);  
		securityManager.setRealms(Arrays.asList((Realm) jdbcRealm));  
		  
		//��SecurityManager���õ�SecurityUtils ����ȫ��ʹ��  
		SecurityUtils.setSecurityManager(securityManager);  
		  
		Subject subject = SecurityUtils.getSubject();  
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		subject.login(token);  
		Assert.assertTrue(subject.isAuthenticated());  
	}
	
}
