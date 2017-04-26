package com.simon.nvwo.jpa.map;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simon.nvwo.jpa.Customer;

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
	
/*	*//**
	 * ������һʱ�������ȱ���1��һ�ˣ��󱣴���һ�ˣ����������ٽ�������update����
	 *//*
	//���
	@Test
	public void testManyToOnePersistence(){
		
		Customer customer=new Customer();
		
		customer.setAge(22);
		customer.setFirstName("koo");
		customer.setLastName("koo");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		Order order1=new Order();
		order1.setOrderName("Koo-1");
		
		Order order2=new Order();
		order2.setOrderName("Koo-2");
		
		//���ù�����ϵ
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		
		//ִ�б������
		manager.persist(customer);
		
		manager.persist(order1);
		manager.persist(order2);
		
		
		
	}
	
	//Ĭ��ʹ������������ȡ�����ֵ
	@Test
	public void testManyToOneFind(){
		
		Order order=manager.find(Order.class, 11);
		
		System.out.println(order.getOrderName());
		
		System.out.println(order.getCustomer().getFirstName());
		
	}
	@Test
	public void testManyToOneRemove(){
		
		Order order=manager.find(Order.class, 1);
		manager.remove(order);
	}*/
	
	/**
	 * ����һ�Զ� 1-n customer-orders
	 * �־û������������ ���෽����ManytoOne���ƣ��ο�����
	 * 
	 * ˫����һҲ�����������ԣ��ȳ־û�1��һ�����ܱȽϿ�
	 * 1��һ�˷���ά��������n��һ��ȥά��
	 *//*
	@Test
	public void testOneToManyPersisence(){
		

		Customer customer=new Customer();
		
		customer.setAge(18);
		customer.setFirstName("fff");
		customer.setLastName("fff");
		customer.setCreatedTime(new Date());
		customer.setUpdateTime(new Date());
		
		
		Order order1=new Order();
		order1.setOrderName("fff-1");
		
		Order order2=new Order();
		order2.setOrderName("fff-2");
		
		Set<Order> orders=new HashSet<Order>();
		
		orders.add(order1);
		orders.add(order2);
		
		//����һ�Զ��ϵ
		
		customer.setOrders(orders);
		
		//�־û�����
		
		manager.persist(customer);
		manager.persist(order1);
		manager.persist(order2);
		
	}*/
	
/*	@Test
	public void testOneToOne(){
		
		Manager manager=new Manager();
		manager.setManagerName("simon");
		
		Department department=new Department();
		department.setDepartmentName("inner");
		
		//����������ϵ
		department.setManager(manager);
		manager.setDepartment(department);
		//�־û�����
		
		this.manager.persist(department);
		this.manager.persist(manager);
		
		
	}*/
	
	/**
	 * ���Զ�Զ��ϵ
	 */
	@Test
	public void testManyToMany(){
		
		
		Category category1=new Category();
		category1.setCatetoryName("fruit");
		
		Category category2=new Category();
		category2.setCatetoryName("flower");
		
		Item item1=new Item();
		item1.setItemName("apple");
		
		Item item2=new Item();
		item2.setItemName("banana");
		
		//���ù�����ϵ
		item1.getCategorys().add(category1);
		item1.getCategorys().add(category2);
		
		item2.getCategorys().add(category1);
		item2.getCategorys().add(category2);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		//�־û�����
		
		manager.persist(item1);
		manager.persist(item2);
		
		manager.persist(category1);
		manager.persist(category2);
	}
	
	
	
	
	
	

}
