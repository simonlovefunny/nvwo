package com.simon.nvwo.shiro.test;




import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest extends BaseTest{
	
	
	//从配置文件获取用户信息进行验证，shiro简单示例
	//@Test
	public void testHelloWorld(){
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		//SecurityManager相当于SpringMVC的DispatcherServlet，管理所有的Subject，
		//负责认证，授权，会话，缓存管理
		Factory<org.apache.shiro.mgt.SecurityManager> factory=
				new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		//org.apache.shiro.SecurityUtils
		// static SecurityManager getSecurityManager()
		// static Subject getSubject()
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    //subject可以认为使一个当前操作者的抽象
	    // UsernamePasswordToken，可以设置让session记住一个token（令牌），可以获取当前用户名和密码
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	    
	   
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	e.printStackTrace();
	    }
	    
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录 
	    
	  //6、退出  
	    subject.logout();  
	}
	
	//简单Realm示例
	//@Test
	public void testCustomerRealm(){
		
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
	}
	
	//测试从数据库获取Realm
	//@Test
	public void testJDBCRealm(){
		
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
	}
	

	
	//测试角色
	//@Test
	public void testHasRole(){
		
	    login("classpath:shiro-role.ini", "zhang", "123");  
	    //判断拥有角色：role1  
	    Assert.assertTrue(subject().hasRole("role1"));  
	    //判断拥有角色：role1 and role2  
	    Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));  
	    //判断拥有角色：role1 and role2 and !role3  
	    boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));  
	    Assert.assertEquals(true, result[0]);  
	    Assert.assertEquals(true, result[1]);  
	    Assert.assertEquals(false, result[2]);
	}
	
	
	//测试角色
	@Test
	public void testHasPermission(){
		
		login("classpath:shiro-permission.ini","zhang","123");
		//断言拥有权限：user:create
		subject().checkPermission("user:create");
		 //断言拥有权限：user:delete and user:update  
	    subject().checkPermissions("user:delete", "user:update");  
	    //断言拥有权限：user:view 会失败抛出异常  
	    subject().checkPermissions("user:view");  
		
	}
	
    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

}
