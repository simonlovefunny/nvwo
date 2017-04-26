package com.simon.nvwo.javaweb.filter.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDao {
	
	private static Map<String,User> users;
	
	private static List<Authority> authorities;
	
	static{
		
		authorities=new ArrayList<Authority>();
		
		authorities.add(new Authority("Article-1", "permission/article-1.jsp"));
		authorities.add(new Authority("Article-2", "permission/article-2.jsp"));
		
		authorities.add(new Authority("Article-3", "permission/article-3.jsp"));
		authorities.add(new Authority("Article-4", "permission/article-4.jsp"));
		
		users=new HashMap<String,User>();
		
		User user1=new User("AAA", authorities.subList(0, 2));
		User user2=new User("BBB", authorities.subList(2, 4));
		
		users.put("AAA", user1);
		users.put("BBB", user2);
	}
	
	/**
	 * 
	* @Title: get
	* @Description: 根据name获取User
	* @param @param name
	* @param @return    参数
	* @return User    返回类型
	* @throws
	 */
	public User get(String username){
		
		return users.get(username);
	}
	
	/**
	 * 
	* @Title: update
	* @Description: 修改用户权限信息
	* @param @param usename
	* @param @param authorities    参数
	* @return void    返回类型
	* @throws
	 */
	public void update(String username,List<Authority> authorities){
		
		users.get(username).setAuthorities(authorities);
	}
	
	/**
	 * 
	* @Title: getAuthorities
	* @Description: 获取用户的权限
	* @param @param username
	* @param @return    参数
	* @return List<Authority>    返回类型
	* @throws
	 */
	public List<Authority> getAuthorities(String username){
		
		return users.get(username).getAuthorities();
	}
	
	/**
	 * 
	* @Title: getAuthorities
	* @Description: 通过前台返回的url获取Authority列表
	* @param @param urls
	* @param @return    参数
	* @return List<Authority>    返回类型
	* @throws
	 */
	public List<Authority> getAuthorities(String[] urls){
		
		List<Authority> authoritiesMirror=new ArrayList<Authority>();
		
		for(Authority authority:authorities){
			
			if(urls != null){
				
				for(String url:urls){
					
					if(url.equals(authority.getUrl())){
						
						authoritiesMirror.add(authority);
					}
				}
			}
			
		}
		
		return authoritiesMirror;
	
	}
	

}
