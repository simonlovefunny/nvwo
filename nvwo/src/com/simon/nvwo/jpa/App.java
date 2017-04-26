package com.simon.nvwo.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
				
		
		//1.创建 EntityManagerFactory
		String persistenceUnitName="nvwo";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory(persistenceUnitName);
		//2.创建Entitymanager
		EntityManager manager=factory.createEntityManager();
		//3.开启事务
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		//4.进行持久化操作
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		manager.persist(customer);
		//5.提交事务
		
		transaction.commit();
		
		//6.关闭EntityManager
		manager.close();
		
		//7.关闭EntityManagerFactory
		
		factory.close();
	}

}
