<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.simon.nvwo.javaweb.javabean.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer(1, "AA", 12));
    customers.add(new Customer(2, "BB", 13));
    customers.add(new Customer(3, "CC", 14));
    customers.add(new Customer(4, "DD", 15));
    customers.add(new Customer(5, "EE", 16));
    
    request.setAttribute("customers", customers);
	%>
	
	
	
	<jsp:forward page="test.jsp"></jsp:forward>
</body>
</html>