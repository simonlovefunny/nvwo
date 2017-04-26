package com.simon.nvwo.javaweb.mvc.dao;

import java.util.List;

public interface CustomerDao {
	
	/**
	 * 
	* @Title: update
	* @Description: TODO(������һ�仰�����������������)
	* @param @param customer    ����
	* @return void    ��������
	* @throws
	 */
	public void update(Customer customer);

	/**
	 * 
	* @Title: getForListWithCriteriaCustomer
	* @Description: ģ����ѯ
	* @param criteriaCustomer
	* @return List<Customer>    ��������
	* @throws
	 */
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer);
	/**
	 * ��ȡ��¼�б�
	 * @return
	 */
	public List<Customer> getAll();
	
	
	/**
	 * �����¼
	 * @param customer
	 */
	public void save(Customer customer);

	/**
	 * ɾ��Customer��¼
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * ��ȡCustomer��¼
	 * @param id
	 */
	public Customer getCustomerById(Integer id);
	
	/**
	 * ���غ�name��ͬ�ļ�¼ @see com.simon.nvwo.javaweb.mvc.dao.Customer.name
	 * @param name
	 * @return
	 */
	public long getCountByName(String name);
}
