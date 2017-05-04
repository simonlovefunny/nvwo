package com.simon.nvwo.shiro.permission;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//ʹ��Authorizing��Realm
public class MyRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//SimpleAuthorizationInfo�Ǽ򵥵�AuthorizationInfo��
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		
		//��ӽ�ɫ
        authorizationInfo.addRole("role1");  
        authorizationInfo.addRole("role2");  
        //����ַ���Ȩ��
        authorizationInfo.addObjectPermission(new BitPermission("+user1+10"));  
        //���ͨ���Ȩ��
        authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));  
        authorizationInfo.addStringPermission("+user2+10");  
        authorizationInfo.addStringPermission("user2:*");  
        return authorizationInfo;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
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

}
