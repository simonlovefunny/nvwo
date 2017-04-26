<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最近的浏览记录</title>
</head>
<body>
	
	<h4>Books Page</h4>
	
	<a href="book.jsp?bookName=JavaWeb">Java Web</a><br><br>
	<a href="book.jsp?bookName=Java">Java</a><br><br>
	<a href="book.jsp?bookName=Oracle">Oracle</a><br><br>
	<a href="book.jsp?bookName=Ajax">Ajax</a><br><br>
	<a href="book.jsp?bookName=JavaScript">JavaScript</a><br><br>
	<a href="book.jsp?bookName=Android">Android</a><br><br>
	<a href="book.jsp?bookName=Jbpm">Jbpm</a><br><br>
	<a href="book.jsp?bookName=Struts">Struts</a><br><br>
	<a href="book.jsp?bookName=Hibernate">Hibernate</a><br><br>
	<a href="book.jsp?bookName=Spring">Spring</a><br><br>
	
	<br><br>
	<%
	//显示cookie
	Cookie[] cookies=request.getCookies();

	if(cookies!=null && cookies.length>0){
		
		for(Cookie cookie:cookies){
			
			if(cookie.getName().startsWith("NVWO_BOOK_")){
			
				out.print(cookie.getValue());
				out.print("<br>");
			}
		}
	}
	

	

	
	%>
</body>
</html>