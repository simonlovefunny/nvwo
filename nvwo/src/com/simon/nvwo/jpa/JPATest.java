package com.simon.nvwo.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JPATest {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	
	@Before
	public void init(){
		
		factory=Persistence.createEntityManagerFactory("nvwo");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
		
		transaction.begin();
	}
	
	@After
	public void  destory(){
		
		transaction.commit();
		
		manager.close();
		
		factory.close();
		
	}
	
/*	//������hibernate ��session��get
	@Test
	public void testFind(){
		//����ֵΪ1
		Customer customer=manager.find(Customer.class, 1);
		
		System.out.println("---------------------");
		
		System.out.println(customer);
	}
	
	////������hibernate ��session��load�������ɴ�����ʹ������ʱ�������ݿ�ȡֵ
	@Test
	public void testGetReference(){
		
		//����ֵΪ1
		Customer customer=manager.getReference(Customer.class, 1);
		
		System.out.println("---------------------");
		
		System.out.println(customer);
	}
	
	//������hibernate ��session��save
	@Test
	public void testPersistence(){
		
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		manager.persist(customer);
		//id���Ա���ӡ��˵�����󱻳־û�
		System.out.println(customer.getId());
	}*/
	
/*	//������hibernate ��session��remove,���ǲ����Ƴ��������hibernate����
	@Test
	public void testRemove(){
		
		Customer customer=manager.find(Customer.class, 6);
		
		manager.remove(customer);
	}*/
	
	/**
	 * ������hibernate��saveorupdate����
	 * 1.���������ʱ���󣬻ᴴ��һ���µĶ��󣬶��¶���ִ�г־û�����������ʱ���󲻻ᱻ�־û�
	 * 
	 */
	@Test
	public void testMergeA(){
		
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		Customer customer2=manager.merge(customer);
		
		System.out.println("Customer#id: "+customer.getId());
		System.out.println("Customer2#id: "+customer2.getId());
	}
	

	/**
	 * ������hibernate��saveorupdate����
	 * 2.�������������󣨶���Customer������id���������ж��Ƿ������ݿ��м�¼��û�м�¼�����¶��󲢳־û���������󲻱��־û���
	 * ����м�¼���ͷ������ݿ�ļ�¼,���Ҵ����¶���ͬʱ�־û�
	 * 
	 */
	@Test
	public void testMergeB(){
		
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		customer.setId(6);
		Customer customer2=manager.merge(customer);
		
		System.out.println("Customer#id: "+customer.getId());
		System.out.println("Customer2#id: "+customer2.getId());
	}
	
	@Test
	public void testFlush(){
		
		Customer customer=manager.find(Customer.class, 1);

		System.out.println(customer);
		
		customer.setLastName("db");
		
		manager.flush();
	}
}
