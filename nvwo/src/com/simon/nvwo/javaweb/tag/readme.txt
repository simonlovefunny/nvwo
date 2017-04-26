JSP自定义标签  具体见com.simon.nvwo.javaweb.tag.HelloSimpleTag
	
	标签对应于标签处理类
	
	简单标签接口  javax.servlet.jsp.tagext.SimpleTag
	
	在WEB-INF下创建xx.tld文件作为标签库的配置文件（/WEB-INF/mytag.tld)
	
	每一个标签需要对应的实现类  com.simon.nvwo.javaweb.tag.HelloSimpleTag--<nvwo:hello/>
标签体 
	<!-- 使用带有标签体的标签 -->
	<nvwo:body>hello</nvwo:body>	
	标签如果设置了标签体<body-content>scriptless/JSP/tagdependent</body-content>,JSP引擎会调用setJspBody（）
	方法把JspFrament传递给标签处理器类，getJspBody()可以获取JspFrament
	
	JspFrament.invoke(null)用于输出标签体
	
	scriptless 标签体可以包含EL表达式和JSP动作元素，不能包含JSP脚本元素
	
	tagdependent 直接将结果给页面，即使是EL也不会处理
	
	JSP	标签体可以包含JSP动作元素
	
	JSP动作元素
    <jsp: include>
    <jsp: param>/<jsp: params>
    <jsp: forward>
    <jsp: useBean>
    <jsp: setProperty>和<jsp:getProperty>
    
	父标签
	<!-- 子标签打印父标签的name属性,子标签作为父标签的标签体存在 -->
	<nvwo:paretnTag>		
	<nvwo:sonTag></nvwo:sonTag>		
	</nvwo:paretnTag>	
	子标签(继承javax.servlet.jsp.tagext.SimpleTagSupport)可以获取父标签的引用 getParent()
	父标签无法获取子标签的引用，仅将子标签作为标签体使用
	
	