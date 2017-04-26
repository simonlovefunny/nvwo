<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 导入自定义标签库 -->
<%@ taglib prefix="nvwo" uri="http://www.simon.com/mytag/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
		<!-- 需要打印设置的属性，执行十次 -->
		<nvwo:hello value="nvwo" count="1"/>
		<!-- 使用带有标签体的标签 -->
		<nvwo:body>hello</nvwo:body>
		
		<!-- 子标签打印父标签的name属性,子标签作为父标签的标签体存在 -->
		<nvwo:paretnTag>
		
		<nvwo:sonTag></nvwo:sonTag>
		
		</nvwo:paretnTag>
		


		
</body>
</html>