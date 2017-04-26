<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.simon.nvwo.javaweb.javabean.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 导入自定义标签库 -->
<%@ taglib prefix="nvwo" uri="http://www.simon.com/mytag/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 遍历customers列表的属性 -->
	<c:forEach items="${requestScope.customers }" var="customer">
		--${customer.id }, ${customer.name }, ${customer.age }<br>
	</c:forEach>
	
	
<%-- 	<c:choose>
		<c:when test="${param.age }">24>大学毕业</c:when>
		<c:when test="${param.age }">20>高中毕业</c:when>
		<c:when test="${param.age }">16>初中毕业</c:when>
		<c:otherwise>小学生</c:otherwise>
	</c:choose> --%>
	

	
<%-- 	<%
	
	List<Customer> customers=(List<Customer>)request.getAttribute("customers");
	
	if(customers !=null&& customers.size()>0){
		
		for(Customer customer:customers){
	%>		
			<%= customer.getName() %>
	<% 
		}
	}
	
	
	
	%> --%>
</body>
</html>