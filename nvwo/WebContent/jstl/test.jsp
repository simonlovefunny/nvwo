<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>JSTL示例</h4>
	
	<c:set var="salary" scope="session" value="${2000*2}"/>
	<c:if test="${salary > 2000}">
   	<p>My salary is: <c:out value="${salary}"/><p>
	</c:if>
	
	<c:choose> 
	<c:when test="${salary <= 0}"> Salary is very low to survive. </c:when> 
	<c:when test="${salary > 1000}"> Salary is very good. </c:when> 
	<c:otherwise> No comment sir... </c:otherwise> 
	</c:choose>
	
	<!-- 打印runoob的页面源代码 -->
	<c:import var="data" url="http://www.baidu.com"/>
	<c:out value="${data}"/>

	
</body>
</html>