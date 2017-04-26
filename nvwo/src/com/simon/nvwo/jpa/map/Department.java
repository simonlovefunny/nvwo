package com.simon.nvwo.jpa.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="jpa_department")
@Entity
public class Department {
	
	private int id;
	
	private String departmentName;
	
	private Manager manager;

	/**
	 * @return the id
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the departmentName
	 */
	@Column(name="department_name")
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the manager
	 */
	//ʹ��@OneToOne��ӳ��һ��һ������ϵ
	//һ��һӳ����Ҫ���unique=true
	@JoinColumn(name="MANAGER_ID",unique=true)
	@OneToOne
	public Manager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	

}
