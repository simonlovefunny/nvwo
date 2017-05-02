package com.simon.nvwo.test;

import com.simon.nvwo.excel.ExcelCell;

public class Mobile {
	
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 电话号码
	 */	
	 @ExcelCell(index = 0)
	private String phone;
	
	/**
	 * 省
	 */
	 @ExcelCell(index = 1)
	private String province;
	
	/**
	 * 市
	 */
	 @ExcelCell(index = 2)
	private String city;
	


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/* 
	* @see java.lang.Object#toString()
	*/ 
	@Override
	public String toString() {
		return "Mobile [phone=" + phone + ", province=" + province + ", city=" + city + "]";
	}



	
	
	
}
