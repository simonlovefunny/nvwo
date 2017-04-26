package com.simon.nvwo.jdbc.jdbctemplate;

import com.simon.nvwo.DAO.Customer;
import com.simon.nvwo.DAO.CustomerDao;
import com.simon.nvwo.DAO.CustomerDaoImpl;

public class TestJdbcTemplate {
	
	public static void main(String[] args) {
		
		
		CustomerDao dao=new CustomerDaoImpl();
		
		Customer customer=new Customer();
		
		customer=dao.getCustomerById(2);
		
		System.out.println(customer.getName());
	}

}
