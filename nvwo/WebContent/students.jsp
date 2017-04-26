<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ page import="com.simon.nvwo.javaweb.mvc.dao.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	
	<%
	
	List<Student> students=(List<Student>)request.getAttribute("students");
	
	%>
	
	<table>
		
		
		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>IDCARD</th>
			<th>EXAMCARD</th>
			<th>STUDENTNAME</th>
			<th>LOCATION</th>
			<th>GRADE</th>
			<th>DELETE</th>
		</tr>
		
		<% 
		for(Student student:students){

		%>
		<tr>
			<td><%=student.getId() %></td>
			<td><%=student.getType() %></td>
			<td><%=student.getIdCard() %></td>
			<td><%=student.getExamCard() %></td>
			<td><%=student.getStudentName()%></td>
			<td><%=student.getLocation() %></td>
			<td><%=student.getGrade() %></td>
			<td><a href="deleteStudent?id=<%=student.getId() %>">DELETE</a></td>
		</tr>
		
	<%
	}
	
	%>	
	</table>

	
</body>
</html>