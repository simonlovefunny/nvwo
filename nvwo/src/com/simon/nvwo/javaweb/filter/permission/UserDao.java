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
	* @Description: ����name��ȡUser
	* @param @param name
	* @param @return    ����
	* @return User    ��������
	* @throws
	 */
	public User get(String username){
		
		return users.get(username);
	}
	
	/**
	 * 
	* @Title: update
	* @Description: �޸��û�Ȩ����Ϣ
	* @param @param usename
	* @param @param authorities    ����
	* @return void    ��������
	* @throws
	 */
	public void update(String username,List<Authority> authorities){
		
		users.get(username).setAuthorities(authorities);
	}
	
	/**
	 * 
	* @Title: getAuthorities
	* @Description: ��ȡ�û���Ȩ��
	* @param @param username
	* @param @return    ����
	* @return List<Authority>    ��������
	* @throws
	 */
	public List<Authority> getAuthorities(String username){
		
		return users.get(username).getAuthorities();
	}
	
	/**
	 * 
	* @Title: getAuthorities
	* @Description: ͨ��ǰ̨���ص�url��ȡAuthority�б�
	* @param @param urls
	* @param @return    ����
	* @return List<Authority>    ��������
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
