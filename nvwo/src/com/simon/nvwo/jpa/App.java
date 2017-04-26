package com.simon.nvwo.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
				
		
		//1.���� EntityManagerFactory
		String persistenceUnitName="nvwo";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory(persistenceUnitName);
		//2.����Entitymanager
		EntityManager manager=factory.createEntityManager();
		//3.��������
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		//4.���г־û�����
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		manager.persist(customer);
		//5.�ύ����
		
		transaction.commit();
		
		//6.�ر�EntityManager
		manager.close();
		
		//7.�ر�EntityManagerFactory
		
		factory.close();
	}

}
