JPA映射
	---单向多对一映射   com.simon.nvwo.jpa.map.Order.getCustomer()
	
	--单向一对多映射  com.simon.nvwo.jpa.Customer.getOrders()
	
	--双向多对一映射 Orders——Customer 即单向 多对一 和 单向 一对多并存的关系
	
	--双向一对一映射 （基于外键） com.simon.nvwo.jpa.map.Manager  
				 com.simon.nvwo.jpa.map.Department
				 
	--双向多对多关系 com.simon.nvwo.jpa.map.Item
				 com.simon.nvwo.jpa.map.Category