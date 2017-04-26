权限管理实现：
	
	需求：
	查看某人的权限
	修改没人的权限
	
	对访问进行权限控制
	
	具体实现：
	
	管理权限
	
		封装权限信息：Authority
	
		封装用户信息：User
	
		创建一个UserDao 
	
	authority-manager.jsp  输入name，查询对应的权限列表
						        选择权限，提交修改（checkbox）				   
	
	servlet查询对应的权限，回传给 authority-manager.jsp显示权限列表
	
	
	难点：
	
	如何回传显示User的权限？
	使用checkbox来显示权限，使用<c:if>和<c:forEach>标签双重循环来判断是否需要勾选权限
	
不雅文字过滤:
		
	技术点：使用 HttpServletRequestWrapper改变传送给request的参数
	
	
	