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
		
		
		<!-- HTMLע�ͣ��ͻ��˿ɼ� -->
		<%-- JSPע�ͣ��ͻ��˲��ɼ� --%>
		<%!	
		//�����ַ���
		String s="simon";
		//��������
		int add(int x,int y){
			
			return x+y;
		}
		
		
		%>
		
		<%
		 //jsp�ű�������дJava����
		 
		 out.println("JSP�����Ϣ");
		
		 //out.println(s);
		 
		 //out.println(add(1,2));
		%>
		<br>
		���,<%=s %><br>
		x+y=<%=add(10,20) %><br>
	
		<!-- ����JSP���ʽ  -->		
		<%
		
		Date date=new Date();
		
		%>	
		

		<%=date %>
		
		<%-- ��������ʹ��ʾ�� --%>
		<%-- request���� --%>
		<%
		//����ͨ������·�������ݲ�������	
/* 		String name=request.getParameter("name");
		System.out.println(name); */
		
		%>
		
		<%--application���� --%>
		<%
		String initParameter=application.getInitParameter("initParameter");
		System.out.println(initParameter);
		%>
		
		<%--config���� --%>	
		<%
		
		System.out.println(config.getInitParameter("test"));
		
		%>
		
		<%-- ��������ת�����ض��� --%>
		
		<a href="forwardServlet">forward</a>
		<!-- ��̬�������JSPҳ�� -->
		<jsp:include page="hello.jsp"></jsp:include>
		<!-- ת�� ,jsp:param���Դ������-->
<%--  		<jsp:forward page="/hello.jsp" >
 		<jsp:param value="testValue" name="test"/>
 		</jsp:forward>
		<%
		
		 request.getRequestDispatcher("/hello.jsp").forward(request, response);
		
		%>  --%>
		
		
		
		
</body>
</html>