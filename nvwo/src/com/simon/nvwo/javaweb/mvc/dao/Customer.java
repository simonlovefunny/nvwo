package com.simon.nvwo.javaweb.mvc.dao;

public class Customer {
	
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	

	public Customer() {
		
	}
	
	
	
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public Customer(Integer id, String name, String address, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



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
	 * @return the name
	 */
	public String getName() {
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
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name 
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
