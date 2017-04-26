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
	//ӳ�䵥����һ��ϵ��n-1��
	// @ManyToOneӳ����һ��ϵ
	// @JoinColumn ������
	// @ManyToOne����ʹ�����������޸�Ĭ�ϵĹ������Լ��ز���
	@JoinColumn(name="CUSTOMER_ID") //˫����һʱ��Ҫ��com.simon.nvwo.jpa.Customer.getOrders()���õ����Ա���һ��
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
