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
	
/*	//类似于hibernate 的session的get
	@Test
	public void testFind(){
		//主键值为1
		Customer customer=manager.find(Customer.class, 1);
		
		System.out.println("---------------------");
		
		System.out.println(customer);
	}
	
	////类似于hibernate 的session的load，先生成代理，在使用属性时才向数据库取值
	@Test
	public void testGetReference(){
		
		//主键值为1
		Customer customer=manager.getReference(Customer.class, 1);
		
		System.out.println("---------------------");
		
		System.out.println(customer);
	}
	
	//类似于hibernate 的session的save
	@Test
	public void testPersistence(){
		
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("funny");
		customer.setLastName("dog");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		manager.persist(customer);
		//id可以被打印，说明对象被持久化
		System.out.println(customer.getId());
	}*/
	
/*	//类似于hibernate 的session的remove,但是不能移除游离对象，hibernate可以
	@Test
	public void testRemove(){
		
		Customer customer=manager.find(Customer.class, 6);
		
		manager.remove(customer);
	}*/
	
	/**
	 * 类似于hibernate的saveorupdate方法
	 * 1.传入的是临时对象，会创建一个新的对象，对新对象执行持久化操作，而临时对象不会被持久化
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
	 * 类似于hibernate的saveorupdate方法
	 * 2.传入的是游离对象（对于Customer就是有id），会先判断是否在数据库有记录，没有记录创建新对象并持久化，游离对象不被持久化，
	 * 如果有记录，就返回数据库的记录,并且创建新对象同时持久化
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
