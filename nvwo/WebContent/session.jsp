<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session管理</title>
</head>
<body>
			
			SessionID:<%= session.getId()%>
			<br><br>
			
			IsNew:<%=session.isNew() %>
			<br><br>
			
			CreatedTime:<%=session.getCreationTime() %>
			<br><br>
			
			LastAccessedTime:<%=session.getLastAccessedTime() %>
			<br><br>
			
			
			<form action="hello.jsp">
			
			username:<input type="text" name="username">
			<input type="submit" value="Submit"/>
			
			</form>
		
<%-- 		<%= session.getId() %>
		
		<%
			
			Cookie cookie=new Cookie("JESSIONID",session.getId());
			cookie.setMaxAge(20);
			response.addCookie(cookie);
		%> --%>
		
<%-- 	<% 
		//手动关闭了session，session="false"
		HttpSession session = request.getSession(true);
		out.println(session);
		out.print("<br>");
		
		//获取 Session 的最大时效, 默认为 30 分钟. 
		out.print(session.getMaxInactiveInterval());
		session.invalidate();
	%> --%>
</body>
</html>