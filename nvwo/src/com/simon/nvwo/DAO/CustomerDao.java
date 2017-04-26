package com.simon.nvwo.DAO;

import java.util.List;

/**
 * ����Customer�Ĳ����ӿ�
 * @author ����
 *
 */
public interface CustomerDao {
	//CRUD
	public void add(Customer customer);
	public void update(Customer customer);
	public void delete(int id);
	public Customer getCustomerById(int id);
	public List<Customer> query();

}
