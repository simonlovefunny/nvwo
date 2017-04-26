package com.simon.nvwo.DAO;

public class TestDao {
	
	public static void main(String[] args) {
		
		CustomerDao dao=new CustomerDaoImpl();
		
		Customer customer=new Customer();
		
		customer=dao.getCustomerById(2);
		
		System.out.println(customer.getName());
	}

}
