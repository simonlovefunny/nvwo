package com.simon.nvwo.javaweb.mvc.dao;



public class Student {
	
	private Integer id;
	
	private Integer type;
	
	private String idCard;
	
	private String examCard;
	
	private String studentName;
	
	private String location;
	
	private Integer grade;
	
	
	public Student() {
		
	}
	
	

	public Student(Integer id, Integer type, String idCard, String examCard, String studentName, String location,
			Integer grade) {
		this.id = id;
		this.type = type;
		this.idCard = idCard;
		this.examCard = examCard;
		this.studentName = studentName;
		this.location = location;
		this.grade = grade;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the examCard
	 */
	public String getExamCard() {
		return examCard;
	}

	/**
	 * @param examCard the examCard to set
	 */
	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
	
	
	

}
