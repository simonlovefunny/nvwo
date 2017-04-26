package com.simon.nvwo.javaweb.filter.permission;


/**
 * 
* @ClassName: Authority
* @Description: 权限实体类
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月9日 上午10:42:47
*
 */
public class Authority {
	
	/**
	 * 权限名称
	 */
	private String displayName;
	
	/**
	 * 权限对应的url，权限的粒度为页面级别，控制用户可访问的页面
	 */
	private String url;
	
	
	public Authority(String displayName, String url) {

		this.displayName = displayName;
		this.url = url;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
