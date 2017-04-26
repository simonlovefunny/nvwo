package com.simon.nvwo.javaweb.mvc.dao;

import java.util.List;

import com.simon.nvwo.DAO.Customer;

/**
 * 对于@see com.simon.nvwo.javaweb.mvc.dao.StudentCRUD操作的接口
 * @author 昭毅
 *
 */
public interface StudentDao {
	
	//CRUD
	public void add(Student student);
	public void update(Student student);
	public void delete(int id);
	public Student getStudentById(int id);
	public List<Student> query();

}
