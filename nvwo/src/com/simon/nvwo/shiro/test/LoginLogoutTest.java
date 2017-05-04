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
	
	
	//�������ļ���ȡ�û���Ϣ������֤��shiro��ʾ��
	//@Test
	public void testHelloWorld(){
		 //1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager  
		//SecurityManager�൱��SpringMVC��DispatcherServlet���������е�Subject��
		//������֤����Ȩ���Ự���������
		Factory<org.apache.shiro.mgt.SecurityManager> factory=
				new IniSecurityManagerFactory("classpath:shiro.ini");
		//2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils  
		//org.apache.shiro.SecurityUtils
		// static SecurityManager getSecurityManager()
		// static Subject getSubject()
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    
	    //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��  
	    //subject������Ϊʹһ����ǰ�����ߵĳ���
	    // UsernamePasswordToken������������session��סһ��token�����ƣ������Ի�ȡ��ǰ�û���������
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	    
	   
	    try {  
	        //4����¼���������֤  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5�������֤ʧ��  
	    	e.printStackTrace();
	    }
	    
	    Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼ 
	    
	  //6���˳�  
	    subject.logout();  
	}
	
	//��Realmʾ��
	//@Test
	public void testCustomerRealm(){
		
		 //1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4����¼���������֤
            subject.login(token);
        } catch (AuthenticationException e) {
            //5�������֤ʧ��
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼

        //6���˳�
        subject.logout();
	}
	
	//���Դ����ݿ��ȡRealm
	//@Test
	public void testJDBCRealm(){
		
        //1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4����¼���������֤
            subject.login(token);
        } catch (AuthenticationException e) {
            //5�������֤ʧ��
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼

        //6���˳�
        subject.logout();
	}
	

	
	//���Խ�ɫ
	//@Test
	public void testHasRole(){
		
	    login("classpath:shiro-role.ini", "zhang", "123");  
	    //�ж�ӵ�н�ɫ��role1  
	    Assert.assertTrue(subject().hasRole("role1"));  
	    //�ж�ӵ�н�ɫ��role1 and role2  
	    Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));  
	    //�ж�ӵ�н�ɫ��role1 and role2 and !role3  
	    boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));  
	    Assert.assertEquals(true, result[0]);  
	    Assert.assertEquals(true, result[1]);  
	    Assert.assertEquals(false, result[2]);
	}
	
	
	//���Խ�ɫ
	@Test
	public void testHasPermission(){
		
		login("classpath:shiro-permission.ini","zhang","123");
		//����ӵ��Ȩ�ޣ�user:create
		subject().checkPermission("user:create");
		 //����ӵ��Ȩ�ޣ�user:delete and user:update  
	    subject().checkPermissions("user:delete", "user:update");  
	    //����ӵ��Ȩ�ޣ�user:view ��ʧ���׳��쳣  
	    subject().checkPermissions("user:view");  
		
	}
	
    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//�˳�ʱ������Subject���߳� ������´β������Ӱ��
    }

}
