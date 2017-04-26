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

	
	
	<h4>Book Detail</h4>
	
	Book:<%= request.getParameter("bookName") %>
	
	
	<br><br>
	
	<a href="books.jsp">return</a>
	<%-- 当NVWO_BOOK开头的cookie大于等于五的时候，若books.jsp传入的 book不在cookie中，
	则删除第一个cookie（NVWO_BOOK数组的第一个cookie）--%>
	<%
	
	String bookName=request.getParameter("bookName");
	
	Cookie[] cookies=request.getCookies();
	//用来存放符合体条件的cookie
	List<Cookie> bookCookies=new ArrayList<Cookie>();
	Cookie tempCookie=null;
	if(cookies!=null && cookies.length>0){
		
		for(Cookie cookie:cookies){
			
			if(cookie.getName().startsWith("NVWO_BOOK_")){
				
				bookCookies.add(cookie);
				//新的cookie已经存在了
				if(cookie.getValue().equals(bookName)){
					 tempCookie=cookie;
				}
			}
		}
	}
	
	//cookie数量已经大于等于五了，而且新的cookie不和原来的重复,则删除第一个cookie
	if(bookCookies.size()>=5 && tempCookie==null){
		
		tempCookie=bookCookies.get(0);
	}
	
	//新的cookie已经存在了，则删除该cookie
	if(tempCookie != null){
		
		tempCookie.setMaxAge(0);
		response.addCookie(tempCookie);
	}
	Cookie cookie=new Cookie("NVWO_BOOK_"+bookName,bookName);
	
	//回传cookie给浏览器
	response.addCookie(cookie);
	
	%>
	
</body>
</html>