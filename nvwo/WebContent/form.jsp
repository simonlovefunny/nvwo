<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.simon.nvwo.javaweb.shopping.TokenProcessor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="<%= request.getContextPath() %>/TokenServlet" method="post">
		
		<input type="hidden" name="NVWO.TOKEN_KEY" 
		  value="<%= TokenProcessor.getInstance().saveToken(request) %>"/> 
		
		name:<input type="text" name="name"/>
		<input type="submit" value="submit"/>
		
	</form>
	
</body>
</html>