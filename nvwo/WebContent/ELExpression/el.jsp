<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.simon.nvwo.javaweb.javabean.Customer" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="el.jsp" method="post">
		
			username: <input type="text" name="username" 
			value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>"/>
			<br>
			<%-- EL表达式获取 --%>
			username: <input type="text" name="username" 
			value="${param.username}"/>
			
			<input type="submit" value="submit">
		 	
		</form>
		
		<%-- username:<%= request.getParameter("username")==null?"":request.getParameter("username")%> --%>
		<%
		//隐含对象范围相关

		%>
		
		<%
			// EL简化代码量
			Customer customer=new Customer();
		    customer.setName("Jerry");
		
			session.setAttribute("customer", customer);
			application.setAttribute("time", new Date());
		%>
		
		username:${customer.name}<br>
		username:${sessionScope.customer["name"]}
		<br>
		
		time:${applicationScope.time}
		<br>
		pageContext:
		<br>
		contextPath:${pageContext.request.contextPath }
		<br>
		sessionId: ${pageContext.session.id }
		<br>
		sessionAttributes: ${pageContext.session.attributeNames }
		<br>
		
		<br>
		<br>
		<br>
</body>
</html>