package com.simon.nvwo.jpa.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.simon.nvwo.jpa.Customer;

@Table(name="jpa_orders")
@Entity
public class Order {
	
	private Integer id;
	
	private String orderName;
	
	private Customer customer;

	/**
	 * @return the id
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the orderName
	 */
	@Column(name="order_name")
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return the customer
	 */
	//映射单向多对一关系（n-1）
	// @ManyToOne映射多对一关系
	// @JoinColumn 添加外键
	// @ManyToOne可以使用懒加载来修改默认的关联属性加载策略
	@JoinColumn(name="CUSTOMER_ID") //双向多对一时需要和com.simon.nvwo.jpa.Customer.getOrders()设置的属性保持一致
	@ManyToOne(fetch=FetchType.LAZY)
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
