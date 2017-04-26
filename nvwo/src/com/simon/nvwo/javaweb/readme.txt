会话和会话状态

	会话跟踪 
	
		--session
			标识 sessionID	
			
			保存sessionID可以使用cookie（JSESSIONID，持久化cookie）
			
			保存session可以使用URL重写实现session追踪，在不允许cookie的浏览器中保持和web服务器的通信
			
			
			session的作用
			
			1).显示会话连接状态
			SessionID:<%= session.getId()%>		
			IsNew:<%=session.isNew() %>
			CreatedTime:<%=session.getCreationTime() %>
			LastAccessedTime:<%=session.getLastAccessedTime() %>
	
			
			2.)保存跨页面的数据
			
			request.getSession().setAttribute("books", books);
			session.getAttribute("books");
			
			session生命周期
				
				1). 默认情况下, 第一次访问一个 WEB 应用的一个 JSP 页面时, 该页面都必须有一个和这个请求相关联的 Session 对象. 
					因为 page 指定的 session 属性默认为 true

				2). 若把 session 属性改为 false, JSP 页面不会要求一定有一个 Session 对象和当前的 JSP 页面相关联
				所以若第一次访问当前 WEB 应用的 JSP 页面时, 就不会创建一个 Session 对象. 

				3). 创建一个 Session 对象: 若 page 指定的 session 设置为 false 或 在 Servlet 中可以通过以下 API 获取 Session 对象. 

				request.getSession(flag): 若 flag 为 true, 则一定会返回一个 HttpSession 对象, 如果已经有和当前 JSP 页面关联的 HttpSession
				对象, 直接返回; 如果没有, 则创建一个新的返回. flag 为 false: 若有关联的, 则返回; 若没有, 则返回 null

				request.getSession(): 相当于 request.getSession(true);
			
				4). Session 对象的销毁: 

				①. 直接调用 HttpSession 的 invalidate()
				②. HttpSession 超过过期时间. 

				> 返回最大时效: getMaxInactiveInterval() 单位是秒
				> 设置最大时效: setMaxInactiveInterval(int interval)
				> 可以在 web.xml 文件中配置 Session 的最大时效, 单位是分钟. 


				③. 卸载当前 WEB 应用. 
				注意: 关闭浏览器不会销毁 Session!
			
		--cookie
			Cookie机制采用的是在客户端保持HTTP状态信息的方案
			
			Cookie是在浏览器访问WEB服务器的某个资源时，有WEB服务器在HTTP响应头中附带给浏览器的小文本文件
			
			一旦web浏览器保存了某个cookie，以后每次访问服务器时，都会在请求头中将这个cookie回传给服务器
			
			底层实现原理：
			web服务器在http响应消息中添加set-cookie响应头，发送给浏览器，浏览器通过在http请求消息中添加cookie请求头字段将cookie
			回传给服务器
			
			一个cookie只能标识一种信息，它至少拥有一个表示该信息的名称（NAME）和值（VALURE）
			
			默认是会话级别的cookie，持久化cookie需要设置maxAge，将其设为0是立即删除该cookie
			
			cookie作用范围，当前目录和当前目录的子目录
			
			cookie实现一定时间内自动登录（保存用户名密码）
			cookie.jsp
			
			cookie显示最近的浏览记录
			books.jsp
			book.jsp
			
				
		
		
