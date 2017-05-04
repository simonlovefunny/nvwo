package com.simon.nvwo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

//shiro��realm��ȡ��ȫ���ݣ�SecurityManager��֤�û���ݣ�Authentication��ʱ����Ҫ��Realm��ȡ��Ӧ���û�
//��֤�û�Ȩ�ޣ�Authorization��ʱ��Ҳ��Ҫ	��Realm��ȡ��Ӧ�Ľ�ɫ��֤�û��Ƿ��ܽ��в���
//Realm���Կ���DataSource,������ini�����ļ����� shiro-realm.ini
public class MyRealm implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  //�õ��û���  
        String password = new String((char[])token.getCredentials()); //�õ�����  
        if(!"zhang".equals(username)) {  
            throw new UnknownAccountException(); //����û�������  
        }  
        if(!"123".equals(password)) {  
            throw new IncorrectCredentialsException(); //����������  
        }  
        //��������֤��֤�ɹ�������һ��AuthenticationInfoʵ�֣�  
        return new SimpleAuthenticationInfo(username, password, getName());  
	}
	
	//����Realm������
	@Override
	public String getName() {
		
		return "MyRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//ֻ֧��org.apache.shiro.authc.UsernamePasswordToken ���͵�token
		return token instanceof UsernamePasswordToken;
	}
		
	
}
