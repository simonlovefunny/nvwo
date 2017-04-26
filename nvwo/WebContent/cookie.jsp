<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%--实现cookie保存用户名功能 --%>
		<%
		
		String name=request.getParameter("name");
		
		if(name != null&& !name.trim().equals("")){
			
			//创建cookie
			Cookie cookie=new Cookie("name",name);
			cookie.setMaxAge(30);
			
			response.addCookie(cookie);
		}else{
			Cookie[] cookies=request.getCookies();
			
			if(cookies!=null&&cookies.length>0){

				for(Cookie cookie:cookies){
					
					String cookieName=cookie.getName();
					if(("name").equals(cookieName)){
						
						name=cookie.getValue();
					}
				}
			}
		}
		
		
		if(name != null&& !name.trim().equals("")){
			
			out.print("Hello: "+name);
		}else{
			
			response.sendRedirect("login.jsp");
		}
		%>
		<%-- <%
		
			//Java Web使用 Cookie类表示 cookie

			Cookie[] cookies=request.getCookies();
			
			if(cookies!=null&&cookies.length>0){
				for(Cookie cookie:cookies){
					
					out.print(cookie.getName()+", "+cookie.getValue());
				}
				
			}else{
				
				out.print("没有Cookie，正在创建cookie。。。");
				Cookie cookie=new Cookie("name","value");
				//存活30s
				cookie.setMaxAge(30);
				response.addCookie(cookie);
				
			}
		%> --%>
</body>
</html>