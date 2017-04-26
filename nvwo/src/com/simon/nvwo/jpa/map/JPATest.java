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
	 * 保存多对一时，建议先保存1的一端，后保存多的一端，这样可以少进行两次update操作
	 *//*
	//添加
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
		
		//设置关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		
		//执行保存操作
		manager.persist(customer);
		
		manager.persist(order1);
		manager.persist(order2);
		
		
		
	}
	
	//默认使用左链接来读取外键的值
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
	 * 单向一对多 1-n customer-orders
	 * 持久化（保存操作） 其余方法和ManytoOne类似，参考即可
	 * 
	 * 双向多对一也可用这个类测试，先持久化1的一端性能比较快
	 * 1的一端放弃维护，交给n的一端去维护
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
		
		//建立一对多关系
		
		customer.setOrders(orders);
		
		//持久化对象
		
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
		
		//建立关联关系
		department.setManager(manager);
		manager.setDepartment(department);
		//持久化对象
		
		this.manager.persist(department);
		this.manager.persist(manager);
		
		
	}*/
	
	/**
	 * 测试多对多关系
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
		
		//设置关联关系
		item1.getCategorys().add(category1);
		item1.getCategorys().add(category2);
		
		item2.getCategorys().add(category1);
		item2.getCategorys().add(category2);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		//持久化对象
		
		manager.persist(item1);
		manager.persist(item2);
		
		manager.persist(category1);
		manager.persist(category2);
	}
	
	
	
	
	
	

}
