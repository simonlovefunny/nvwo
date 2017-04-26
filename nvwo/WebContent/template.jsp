<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>	
		
		
		<!-- HTML注释，客户端可见 -->
		<%-- JSP注释，客户端不可见 --%>
		<%!	
		//声明字符串
		String s="simon";
		//声明方法
		int add(int x,int y){
			
			return x+y;
		}
		
		
		%>
		
		<%
		 //jsp脚本，可以写Java代码
		 
		 out.println("JSP输出信息");
		
		 //out.println(s);
		 
		 //out.println(add(1,2));
		%>
		<br>
		你好,<%=s %><br>
		x+y=<%=add(10,20) %><br>
	
		<!-- 测试JSP表达式  -->		
		<%
		
		Date date=new Date();
		
		%>	
		

		<%=date %>
		
		<%-- 隐含对象使用示例 --%>
		<%-- request对象 --%>
		<%
		//可以通过请求路径来传递参数进来	
/* 		String name=request.getParameter("name");
		System.out.println(name); */
		
		%>
		
		<%--application对象 --%>
		<%
		String initParameter=application.getInitParameter("initParameter");
		System.out.println(initParameter);
		%>
		
		<%--config对象 --%>	
		<%
		
		System.out.println(config.getInitParameter("test"));
		
		%>
		
		<%-- 测试请求转发和重定向 --%>
		
		<a href="forwardServlet">forward</a>
		<!-- 动态包含别的JSP页面 -->
		<jsp:include page="hello.jsp"></jsp:include>
		<!-- 转发 ,jsp:param可以传入参数-->
<%--  		<jsp:forward page="/hello.jsp" >
 		<jsp:param value="testValue" name="test"/>
 		</jsp:forward>
		<%
		
		 request.getRequestDispatcher("/hello.jsp").forward(request, response);
		
		%>  --%>
		
		
		
		
</body>
</html>