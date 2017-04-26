package com.simon.nvwo.jpa.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="jpa_managers")
@Entity
public class Manager {
	
	private int id;
	
	private String  managerName;
	
	private Department department;

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
	 * @return the managerName
	 */
	@Column(name="manager_name")
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the department
	 */
	//放弃维护关联关系，使用com.simon.nvwo.jpa.map.Department.manager来进行映射
	@OneToOne(mappedBy="manager")
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
