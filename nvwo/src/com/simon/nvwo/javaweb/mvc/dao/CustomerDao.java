package com.simon.nvwo.javaweb.mvc.dao;

import java.util.List;

public interface CustomerDao {
	
	/**
	 * 
	* @Title: update
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param customer    参数
	* @return void    返回类型
	* @throws
	 */
	public void update(Customer customer);

	/**
	 * 
	* @Title: getForListWithCriteriaCustomer
	* @Description: 模糊查询
	* @param criteriaCustomer
	* @return List<Customer>    返回类型
	* @throws
	 */
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer);
	/**
	 * 获取记录列表
	 * @return
	 */
	public List<Customer> getAll();
	
	
	/**
	 * 保存记录
	 * @param customer
	 */
	public void save(Customer customer);

	/**
	 * 删除Customer记录
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 获取Customer记录
	 * @param id
	 */
	public Customer getCustomerById(Integer id);
	
	/**
	 * 返回和name相同的记录 @see com.simon.nvwo.javaweb.mvc.dao.Customer.name
	 * @param name
	 * @return
	 */
	public long getCountByName(String name);
}
