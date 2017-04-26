package com.simon.nvwo.javaweb.mvc.dao;


/**
 * 
* @ClassName: CriteriaCustomer
* @Description: 封装查询条件的customer类
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月3日 下午8:53:08
*
 */
public class CriteriaCustomer {
	
	private String name;
	
	private String address;
	
	private String phone;
	
	
	public CriteriaCustomer(String name, String address, String phone) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		if(this.name==null){
			
			this.name="%%";
		}else{
			
			this.name="%"+name+"%";
		}
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		if(this.address==null){
			
			this.address="%%";
		}else{
			
			this.address="%"+address+"%";
		}
		
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		
		if(this.phone==null){
			
			this.phone="%%";
		}else{
			
			this.phone="%"+phone+"%";
		}
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
