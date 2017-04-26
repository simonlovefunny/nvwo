package com.simon.nvwo.javaweb.filter.permission;

import java.util.List;

/**
 * 
* @ClassName: User
* @Description: 用户实体类
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月9日 上午10:42:57
*
 */
public class User {
	
	private String username;
	
	private  List<Authority> authorities;
	
	
	public User(String username, List<Authority> authorities) {
		super();
		this.username = username;
		this.authorities = authorities;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
	
	

}
