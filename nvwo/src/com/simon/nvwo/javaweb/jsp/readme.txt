 
JSP
	��ҳ���мȿ���ʹ��htmlҲ����ʹ��java

	JSPָ�
	
	Page ͨ��λ��JSPҳ��Ķ��ˣ�ͬһ��ҳ������ж��Page   ָ��
	
	<%@ page
	[language="Java"]  ����JSPҳ��ʹ�õĽű����Ե����࣬Ĭ��ΪJava
	[buffer="none| size kb "] 	ָ��out����ʹ�û������Ĵ�С��Ĭ��Ϊ8kb
    [autoFlush="true|false"] 	������������������ʱ���Ƿ�ǿ����������������ݣ�Ϊfalseʱ���������쳣
	[contentType=""] 	���������͸��ͻ���ʱ�����ݱ���
	[pageEncoding=""]  	JSPҳ��ı����ʽ
	[errorPage="relativeURL"] 	ָ����JSPҳ�淢���쳣ʱ��Ҫת��Ĵ�����ҳ��
	[isErrorPage="true|false"] 	ָ����ǰҳ���Ƿ������Ϊ��һ��JSPҳ��Ĵ�����ҳ��
	[extends="package.class"] 	ָ��Jspҳ�������ɵ�servlet�ĳ���,һ�����ʹ�����ָ��
	[import="java.xxx.*"] 	����Ҫʹ�õ�Java��
	[info="text"] 	����JSPҳ���������Ϣ,��JSpҳ���У�����ֱ��ͨ��getServletInfo()��ȡ
	[isThreadSafe="true|false"] 	ָ����JSPҳ��ķ����Ƿ�Ϊ�̰߳�ȫ
	[session="true|false"] 	ָ��JSPҳ���Ƿ�ʹ��session
	[isELIgnored="true|false"] 	ָ���Ƿ�ִ��EL���ʽ
	[isScriptingEnabled="true|false"] 	ȷ���ű�Ԫ���ܷ�ʹ��
	%>
	
	include ��һ���ⲿ�ļ�Ƕ�뵱ǰjsp�ļ������ҽ���JSP���
	
	<%@include file="relativeURL"%>
	
	taglib ʹ�ñ�ǩ���Զ���
	
	
	JSPҳ�����������
    javax.servlet.http.HttpSession session ����һ�����ӣ��ͻ����������վ�㽨������ʱ���Ự��ʼ�����ͻ��˹ر������ʱ���Ự����
    javax.servlet.ServletContext application JSPҳ�������ģ����Է���WEBӦ�õĹ�������
    javax.servlet.ServletConfig config JSP��������Ϣ�����Ի�ȡ���������Ϣ,����ʱ������ʹ��
    javax.servlet.jsp.JspWriter out	�����������
    java.lang.Object page = this	JSPҳ�汾������������ʹ��
    javax.servlet.http.HttpServletRequest request ��װ��������Ϣ
    javax.servlet.http.HttpServletResponse response	 ��װ�˷������Կͻ��˵���Ӧ��һ�㲻ֱ��ʹ�ã���ʹ�� out����
    javax.servlet.jsp.PageContext pageContext ��ǰҳ��������ģ����Է��������������󣬿��������Զ����ǩ

	
	�����
	application  setAttribute(java.lang.String name, java.lang.Object object) ���õĲ���������Ӧ�����涼���Է���
				 java.lang.Object 	getAttribute(java.lang.String name)
				 java.util.Enumeration 	getAttributeNames()
	
	pageContext ���Է��ʵ����Խ����ڵ�ǰJSPҳ��
				 setAttribute(java.lang.String name, java.lang.Object object) 
				 java.lang.Object 	getAttribute(java.lang.String name)
	
	session  ������һ�λỰ
			setAttribute(java.lang.String name, java.lang.Object object) 
		    java.lang.Object 	getAttribute(java.lang.String name)
	
	
	�����ض����ת��
	
	ת����ֻ����һ�����󣬵�ַurl�ǳ��η�������ĵ�ַ��ת������Է���ԭ������������
	�ض��򣺷����������󣬵�ַ�����������ĵ�ַ���ض����޷�����ԭ������������
	
	JSP��ǩ
	
	�١���̬�������JSPҳ��
	<jsp:include page=""></jsp:include>
	
	�ڡ�ҳ��ת��
	<jsp:forward page=""></jsp:forward>
		
	