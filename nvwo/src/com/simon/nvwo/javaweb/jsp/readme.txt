 
JSP
	在页面中既可以使用html也可以使用java

	JSP指令：
	
	Page 通常位于JSP页面的顶端，同一个页面可以有多个Page   指令
	
	<%@ page
	[language="Java"]  声明JSP页面使用的脚本语言的种类，默认为Java
	[buffer="none| size kb "] 	指定out对象使用缓冲区的大小，默认为8kb
    [autoFlush="true|false"] 	当输出缓冲区即将溢出时，是否强制输出缓冲区的内容，为false时溢出会产生异常
	[contentType=""] 	服务器发送给客户端时的内容编码
	[pageEncoding=""]  	JSP页面的编码格式
	[errorPage="relativeURL"] 	指定当JSP页面发生异常时需要转向的错误处理页面
	[isErrorPage="true|false"] 	指定当前页面是否可以作为另一个JSP页面的错误处理页面
	[extends="package.class"] 	指定Jsp页面所生成的servlet的超类,一般避免使用这个指令
	[import="java.xxx.*"] 	导入要使用的Java类
	[info="text"] 	定义JSP页面的描述信息,在JSp页面中，可以直接通过getServletInfo()获取
	[isThreadSafe="true|false"] 	指定对JSP页面的访问是否为线程安全
	[session="true|false"] 	指定JSP页面是否使用session
	[isELIgnored="true|false"] 	指定是否执行EL表达式
	[isScriptingEnabled="true|false"] 	确定脚本元素能否被使用
	%>
	
	include 将一个外部文件嵌入当前jsp文件，并且解析JSP语句
	
	<%@include file="relativeURL"%>
	
	taglib 使用标签库自定义
	
	
	JSP页面的隐含对象
    javax.servlet.http.HttpSession session 代表一次连接，客户端浏览器和站点建立连接时，会话开始，当客户端关闭浏览器时，会话结束
    javax.servlet.ServletContext application JSP页面上下文，可以访问WEB应用的共享数据
    javax.servlet.ServletConfig config JSP的配置信息，可以获取配置相关信息,开发时几乎不使用
    javax.servlet.jsp.JspWriter out	可以用于输出
    java.lang.Object page = this	JSP页面本身，开发几乎不使用
    javax.servlet.http.HttpServletRequest request 封装了请求信息
    javax.servlet.http.HttpServletResponse response	 封装了服务器对客户端的响应，一般不直接使用，而使用 out对象
    javax.servlet.jsp.PageContext pageContext 当前页面的上下文，可以访问其他隐含对象，可以用于自定义标签

	
	域对象
	application  setAttribute(java.lang.String name, java.lang.Object object) 设置的参数在整个应用里面都可以访问
				 java.lang.Object 	getAttribute(java.lang.String name)
				 java.util.Enumeration 	getAttributeNames()
	
	pageContext 可以访问的属性仅限于当前JSP页面
				 setAttribute(java.lang.String name, java.lang.Object object) 
				 java.lang.Object 	getAttribute(java.lang.String name)
	
	session  仅限于一次会话
			setAttribute(java.lang.String name, java.lang.Object object) 
		    java.lang.Object 	getAttribute(java.lang.String name)
	
	
	请求重定向和转发
	
	转发：只发送一次请求，地址url是初次发送请求的地址，转发后可以访问原来的请求数据
	重定向：发送两次请求，地址栏是最后请求的地址，重定向无法访问原来的请求数据
	
	JSP标签
	
	①。动态包含别的JSP页面
	<jsp:include page=""></jsp:include>
	
	②。页面转发
	<jsp:forward page=""></jsp:forward>
		
	