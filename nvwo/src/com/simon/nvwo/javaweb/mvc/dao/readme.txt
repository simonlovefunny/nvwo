模糊查询
	
	index.jsp
	
	根据传入的name，address,phone进行模糊查询，SQL语句为SELECT id,name,address,phone FROM customer_info
	WHERE name like "%name%" AND address like "%address%" AND phone like "%phone%";
	
	在com.simon.nvwo.javaweb.mvc.dao.CustomerDao接口中定义
	getForListWithCriteriaCustomer(CriteriaCustomer cc)用于封装查询条件
	

		