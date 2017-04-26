<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
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
			
			<%
			
			out.print("hello");
			
			%>
			
			<br><br>

</body>
</html>