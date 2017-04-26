package com.simon.nvwo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.simon.nvwo.javaweb.mvc.dao.CriteriaCustomer;
import com.simon.nvwo.javaweb.mvc.dao.Customer;
import com.simon.nvwo.javaweb.mvc.dao.CustomerDao;
import com.simon.nvwo.javaweb.mvc.dao.CustomerDaoImpl;

public class CustomerDaoImplTest {
	
	
	private CustomerDao customerDao=new CustomerDaoImpl();
	
/*	@Test
	public void testGetAll() {
		
		List<Customer> customers=customerDao.getAll();
		
		for(Customer customer:customers){
			
			System.out.println(customer.getName());
		}
	}*/

/*	@Test
	public void testSave() {
		
		Customer customer=new Customer(3, "Catty", "333", "333");
		customerDao.save(customer);
	}*/

/*	@Test
	public void testDelete() {
		
		System.out.println(customerDao.getCustomerById(3));
		customerDao.delete(3);
		System.out.println(customerDao.getCustomerById(3));
	}*/

/*	@Test
	public void testGetCustomerById() {
		
		System.out.println(customerDao.getCustomerById(1));
	}*/

/*	@Test
	public void testGetCountByName() {
		
		System.out.println(customerDao.getCountByName("Jerry"));
	}*/
	
/*	@Test
	public void testFuzzyQuery(){
		
		CriteriaCustomer criteriaCustomer=new CriteriaCustomer("","111","");
		
		List<Customer> customer=customerDao.getForListWithCriteriaCustomer(criteriaCustomer);
		
		System.out.println(customer);
	}*/
	

}
