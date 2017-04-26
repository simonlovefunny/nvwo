package com.simon.nvwo.DAO;

/**
 * 对应数据库test表user_info
 * @author 昭毅
 *
 */
public class Customer {
	
	private int id;
	
	private int age;
	
	private String name;
	
	private String password;
	
	public Customer(){
		
	}
	public Customer(int id,int age,String name,String password){
		
		this.id=id;
		this.age=age;
		this.name=name;
		this.password=password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
