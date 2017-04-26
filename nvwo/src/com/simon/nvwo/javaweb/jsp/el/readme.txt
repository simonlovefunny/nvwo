JSP的EL表达式  http://blog.csdn.net/zdwzzu2006/article/details/4672383

	EL 提供了在 JSP 脚本编制元素范围外使用运行时表达式的功能。
	脚本编制元素是指页面中能够用于在 JSP 文件中嵌入 Java 代码的元素。
	它们通常用于对象操作以及执行那些影响所生成内容的计算。JSP 
	2.0 将 EL 表达式添加为一种脚本编制元素
	
	EL语法   ${expression}
	  ${ObjectName.属性}
	  首先会从当前页面中寻找之前是否定义了ObjectName，如果没有找到则依次到Request、Session、
	 Application 范围内寻找，直到找到为止。如果直到最后依然没有找到匹配的
	  变量，则返回null
	  
	  
	  EL 提供“.“和“[ ]“两种运算符来存取数据  如果要动态取值时，就可以用“[ ]“来做，而“.“无法做到动态取值
	  ${sessionScope.user[data]}中data 是一个变量
	      当要存取的属性名称中包含一些特殊字符，如.或?等并非字母或数字的符号，就一定要使用“[ ]“
	  ${user.My-Name}应当改为${user["My-Name"] }
	  
	  
	  属性范围在EL中的名称
     Page             PageScope
     Request          RequestScope
     Session          SessionScope
     Application      ApplicationScope
         
            用法
            
    pageScope
	将页面范围的变量名称映射到其值。
	例如，EL 表达式可以使用 ${pageScope.objectName} 访问一个 JSP 中页面范围的对象，
	还可以使用 ${pageScope.objectName.attributeName} 访问对象的属性。

	requestScope
	

	将请求范围的变量名称映射到其值。该对象允许访问请求对象的属性。
	例如，EL 表达式可以使用 ${requestScope.objectName} 访问一个 JSP 请求范围的对象，
	还可以使用 ${requestScope.objectName.attributeName} 访问对象的属性。

	sessionScope

	将会话范围的变量名称映射到其值。该对象允许访问会话对象的属性。例如：
	${sessionScope.name} 

	applicationScope
	
	将应用程序范围的变量名称映射到其值。该隐式对象允许访问应用程序范围的对象。

  
           隐式对象	 
    pageContext
 	JSP 页的上下文。它可以用于访问 JSP 隐式对象，如请求、响应、会话、输出、servletContext 等。
 	例如，${pageContext.response}
 	
 	param
	将请求参数名称映射到单个字符串参数值（通过调用 ServletRequest.getParameter (String name) 获得）。
	getParameter (String) 方法返回带有特定名称的参数。
	表达式 $(param.name) 相当于 request.getParameter (name)。
	
	paramValues
	将请求参数名称映射到一个数值数组（通过调用 ServletRequest.getParameter (String name) 获得）。
	它与 param 隐式对象非常类似，但它检索一个字符串数组而不是单个值。
	表达式 ${paramvalues.name) 相当于 request.getParamterValues(name)。
	
	header
	将请求头名称映射到单个字符串头值（通过调用 ServletRequest.getHeader(String name) 获得）。
	表达式 ${header.name} 相当于 request.getHeader(name)。
	
	headerValues
	将请求头名称映射到一个数值数组（通过调用 ServletRequest.getHeaders(String) 获得）。它与头隐式对象非常类似。
	表达式 ${headerValues.name} 相当于 request.getHeaderValues(name)。
 	
 	cookie
 	将 cookie 名称映射到单个 cookie 对象。向服务器发出的客户端请求可以获得一个或多个 cookie。表达式 ${cookie.name.value} 返回带有特定名称的第一个 cookie 值。
 	如果请求包含多个同名的 cookie，则应该使用 ${headerValues.name} 表达式
 	
 	initParam 	将上下文初始化参数名称映射到单个值（通过调用 ServletContext.getInitparameter(String)
 	
 	<%@ page isELIgnored="true" %> 表示是否禁用EL语言,TRUE表示禁止.FALSE表示不禁止.JSP2.0中默认的启用EL语言。
 	
 	在spring 中，所有逻辑处理单元返回的结果数据，都将作为Attribute 被放
	置到HttpServletRequest 对象中返回（具体实现可参见Spring 源码中
	org.springframework.web.servlet.view.InternalResourceView.
	exposeModelAsRequestAttributes方法的实现代码）SpringMVC 中，结果数据对象默认都是requestScope
	
EL自定义函数
	编写JaVa静态类和静态方法