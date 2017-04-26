<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.simon.nvwo.javaweb.javabean.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="customer" class="com.simon.nvwo.javaweb.javabean.Customer" scope="session">	
	</jsp:useBean>	
	<jsp:setProperty property="age"  value="10" name="customer"/>

	age:<jsp:getProperty property="age" name="customer"/>
	
	<% 
	Customer customerMirror=(Customer)session.getAttribute("customer");
	
	//如果获取不到session中的Customer对象，则通过反射创建新的Customer实例
	if(customerMirror==null){
		
		customerMirror=(Customer)Class.forName("com.simon.nvwo.javaweb.javabean.Customer").newInstance();
	
		session.setAttribute("customer", customerMirror);
	}
	
	
	%>

</body>
</html>