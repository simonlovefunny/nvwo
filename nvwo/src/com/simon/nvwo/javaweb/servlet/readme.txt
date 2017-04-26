
public abstract class GenericServlet

	HttpServlet的抽象父类，实现了Servlet接口
	
	
浏览器和WEB服务器连接过程是短暂的，每次只有一个请求和相应

Servlet容器：运行Servlet、JSP、Filter等的软件环境

                            创建Servlet,并调用Servlet相关生命周期



Servlet生命周期，以下方法都是由Servlet容器负责调用

1).第一次请求对应Servlet时，调用构造器方法

2).init()初始化，只被调用一次，在创建好实例后立即被调用，用于初始化Servlet
 --ServletConfig对象
	public void init(ServletConfig config)
	ServletConfig封装了Servlet的配置信息，并且可以获取ServletContext对象
	web.xml配置init-parameter参数
	getInitParameter(java.lang.String name)获取初始化参数
	getInitParameterNames()获取所有的初始化参数名称的枚举类
	
 --ServletContext对象
 	Servlet引擎为每个Servlet创建了ServletContext，其可以通过ServletConfig获取 getServletContext()
 	ServletContext代表当前WEB应用的管理器，可以获取当前WEB应用各方面的信息
 	
 	①。获取web应用的初始化参数
 	web初始化参数在web.xml设置
 	<context-param>
 	<param-name></param-name>
 	<param-value></param-value>
 	</context-param>
 	
 	②。获取当前WEB 应用某个文件在服务器上的绝对路径，而不是部署的路径
 	getPath(String fileName)
 	
 	③。获取当前web 的根目录
 	getContextPath()
 	
 	④。获取当前WEB 应用某一个文件的输入流
 	getResourceAsStream(String path)  path为getPath(String fileName)获取的目录
 	
 	
 	
3).service()方法被多次调用，每次请求都会调用Service()方法

4).destory()销毁方法，只被调用一次，在当前Servlet所在web应用被卸载前调用，用于释放当前Servlet咱用的资源


Servlet处理请求，ServletRequest封装了请求信息，可以获取任何请求信息
				--  java.lang.String 	getParameter(java.lang.String name)：根据请求参数名称，获取参数值,只能获取第一个提交的值
				
				--  java.lang.String[] 	getParameterValues(java.lang.String name)：获取请求参数的数组，适用于有多个提交值（多选）
				
				--  java.util.Enumeration 	getParameterNames() 返回所有请求参数名字的枚举对象
				
				--  java.util.Map 	getParameterMap() 返回所有请求参数的键值k-v对，值是String[] 类型
				
				
				
				
			   ServletResponse封装了响应信息，可以给用户响应
			   
			   --getWriter():返回PrintWriter对象，可以给客户端返回信息
			   
			   --setContentType(java.lang.String type) 设置响应格式 MINE TYPE
			   http://www.w3school.com.cn/media/media_mimeref.asp
			   
			   --sendRedirect(java.lang.String location) 重定向方法
			   
	
	
	