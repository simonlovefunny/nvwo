package com.simon.nvwo.javaweb.mvc.dao;

import java.util.List;

import com.simon.nvwo.DAO.Dao;

public class CustomerDaoImpl extends Dao<Customer> implements CustomerDao{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql="SELECT id,name,address,phone FROM customer_info";
		
		
		return  getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		
		String sql="INSERT INTO customer_info(id,name,address,phone) VALUES(?,?,?,?)";
		
		update(sql, customer.getId(),customer.getName(),customer.getAddress(),customer.getPhone());
		
	}

	@Override
	public void delete(int id) {
		
		String sql="DELETE FROM customer_info WHERE id=?";
		
		update(sql, id);
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		
		String sql="SELECT id,name,address,phone FROM customer_info where id=?";
		
		return query(sql, id);
	}

	@Override
	public long getCountByName(String name) {
		
		String sql="SELECT COUNT(id) FROM customer_info where name=?";
		
		return getForValue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer) {
		// TODO Auto-generated method stub
		
		String sql="SELECT id,name,address,phone FROM customer_info WHERE "+
					"name LIKE ? AND address like ? AND phone like ?";
		
		
		return getForList(sql,criteriaCustomer.getName(),criteriaCustomer.getAddress(),criteriaCustomer.getPhone() );
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customer_info SET name = ?, address = ?, phone = ? " +
				"WHERE id = ?";
		update(sql, customer.getName(), customer.getAddress(), 
				customer.getPhone(), customer.getId());
	}
	
	


	


}
