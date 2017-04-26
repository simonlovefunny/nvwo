<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.simon.nvwo.javaweb.mvc.dao.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<form action="fuzzyQuery.do" method="post">
		
			<table>
				<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"/></td>
				</tr>
				
				<tr>
				<td>Address:</td>
				<td><input type="text" name="address"/></td>
				</tr>
				
				<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"/></td>
				</tr>
				
				<tr>
				<td><input type="submit" value="QUERY"/></td>
				<td><a href="addCustomer.jsp">Add New Customer</a></td>
				</tr>
			
			</table>
		</form>
		
		<br><br>
		
		<%
		
		List<Customer> customers=(List<Customer>)request.getAttribute("customers");
		if(customers!=null&&customers.size()>0){

		%>
		
		<hr>
		<br><br>
		
		<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>PHONE</th>
					<th>UPDATE\DELETE</th>
				</tr>
				
		<%
		
		for(Customer customer:customers){
			

		%>
				<tr>
					<td><%=customer.getId()%></td>
					<td><%=customer.getName()%></td>
					<td><%=customer.getAddress()%></td>
					<td><%=customer.getPhone()%></td>
					<td>
						<a href="update.do?id=<%= customer.getId() %>">UPDATE</a>
						<a href="delete.do?id=<%= customer.getId() %>">DELETE</a>
					</td>
				</tr>
		

		<%      } %>
		
		</table>

		<%		} %>
</body>
</html>