ģ����ѯ
	
	index.jsp
	
	���ݴ����name��address,phone����ģ����ѯ��SQL���ΪSELECT id,name,address,phone FROM customer_info
	WHERE name like "%name%" AND address like "%address%" AND phone like "%phone%";
	
	��com.simon.nvwo.javaweb.mvc.dao.CustomerDao�ӿ��ж���
	getForListWithCriteriaCustomer(CriteriaCustomer cc)���ڷ�װ��ѯ����
	

		