package com.simon.nvwo.javaweb.javabean;

import java.util.Date;

public class Customer {
	
	private Integer id;
	
	private String name;
	
	private int age;
	
	
	/**
	 * 
	* <p>Title: 无参构造器</p>
	* <p>Description:提供给jsp:userbean标签使用 </p>
	 */
	public Customer() {
		System.out.println("JavaBean实体类"+new Date());
	}
	
	
	public Customer(Integer id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
