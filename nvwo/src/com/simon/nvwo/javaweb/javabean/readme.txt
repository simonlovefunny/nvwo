Jsp中使用JavaBean

	<jsp:useBean>标签
	
	JavaBean实体类需要有无参的构造器
	
	声明JavaBean对象
	
	<jsp:useBean id="id" class="bean 编译的类" scope="bean 作用域">	</jsp:useBean>
   		<jsp:setProperty name="bean 的 id" property="属性名"  
                    value="value"/>
   		<jsp:getProperty name="bean 的 id" property="属性名"/>


	
	JavaBean生命周期
	
	默认为page，在用户访问当前页面时有效，当页面跳转后JavaBean被销毁
	
	可选项： request  session  application
	
	客户每次请求访问jsp页面时，都会创建新的javabean对象。Javabean对象的有效范围为：


	request 
	1.客户请求访问的当前jsp网页。
	
	2.和当前网页共享一个客户请求的网页，即当前jsp网页中<%@include %>指令以及<forward>标记包含的其他jsp文件
	
	3.当所有共享同一个客户请求的jsp页面执行完毕并向客户端发加响应时，javabean对象结束生命周期。
	
	4.javabean对象作为属性保存在httpRequest对象中，属性名javabean的id,属性值为javabean对象，因此可以通过HttpRequest.getAttribute()方法取得javabean对象
	
	session
	1.Javabean对象被创建后，它存在于整个session的生命周期内，现个session中的jsp文件共享这个javabean对象。
	
	2.javabean对象作为属性保存在HttpSession对象中，属性名为javabean的id,属性值为javabean对象。除了可以通过javabean的id直接引用javabean对象外，也可以通过HttpSession.getAttribute（）方法取得javabean对象
	
	application
	1.javabean对象被创建后，它存在于整个web应用的生命周期内，web应用中的所有jsp文件都能共享同一个javabean对象。

	2.javabean对象作为属性保存在application对象中，属性名为javabean的id，属性值为javabean对象，除了可以通过javabean的id直接引用对象外，也可以通过javabean的application.getAttribute()方法取得javabean对象	 