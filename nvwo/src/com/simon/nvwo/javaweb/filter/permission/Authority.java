package com.simon.nvwo.javaweb.filter.permission;


/**
 * 
* @ClassName: Authority
* @Description: Ȩ��ʵ����
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��9�� ����10:42:47
*
 */
public class Authority {
	
	/**
	 * Ȩ������
	 */
	private String displayName;
	
	/**
	 * Ȩ�޶�Ӧ��url��Ȩ�޵�����Ϊҳ�漶�𣬿����û��ɷ��ʵ�ҳ��
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
