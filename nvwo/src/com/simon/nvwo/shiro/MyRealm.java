package com.simon.nvwo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

//shiro从realm获取安全数据，SecurityManager验证用户身份（Authentication）时，需要从Realm获取对应的用户
//验证用户权限（Authorization）时，也需要	从Realm获取对应的角色验证用户是否能进行操作
//Realm可以看成DataSource,可以用ini配置文件配置 shiro-realm.ini
public class MyRealm implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  //得到用户名  
        String password = new String((char[])token.getCredentials()); //得到密码  
        if(!"zhang".equals(username)) {  
            throw new UnknownAccountException(); //如果用户名错误  
        }  
        if(!"123".equals(password)) {  
            throw new IncorrectCredentialsException(); //如果密码错误  
        }  
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
        return new SimpleAuthenticationInfo(username, password, getName());  
	}
	
	//设置Realm的名字
	@Override
	public String getName() {
		
		return "MyRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//只支持org.apache.shiro.authc.UsernamePasswordToken 类型的token
		return token instanceof UsernamePasswordToken;
	}
		
	
}
