
public abstract class GenericServlet

	HttpServlet�ĳ����࣬ʵ����Servlet�ӿ�
	
	
�������WEB���������ӹ����Ƕ��ݵģ�ÿ��ֻ��һ���������Ӧ

Servlet����������Servlet��JSP��Filter�ȵ��������

                            ����Servlet,������Servlet�����������



Servlet�������ڣ����·���������Servlet�����������

1).��һ�������ӦServletʱ�����ù���������

2).init()��ʼ����ֻ������һ�Σ��ڴ�����ʵ�������������ã����ڳ�ʼ��Servlet
 --ServletConfig����
	public void init(ServletConfig config)
	ServletConfig��װ��Servlet��������Ϣ�����ҿ��Ի�ȡServletContext����
	web.xml����init-parameter����
	getInitParameter(java.lang.String name)��ȡ��ʼ������
	getInitParameterNames()��ȡ���еĳ�ʼ���������Ƶ�ö����
	
 --ServletContext����
 	Servlet����Ϊÿ��Servlet������ServletContext�������ͨ��ServletConfig��ȡ getServletContext()
 	ServletContext����ǰWEBӦ�õĹ����������Ի�ȡ��ǰWEBӦ�ø��������Ϣ
 	
 	�١���ȡwebӦ�õĳ�ʼ������
 	web��ʼ��������web.xml����
 	<context-param>
 	<param-name></param-name>
 	<param-value></param-value>
 	</context-param>
 	
 	�ڡ���ȡ��ǰWEB Ӧ��ĳ���ļ��ڷ������ϵľ���·���������ǲ����·��
 	getPath(String fileName)
 	
 	�ۡ���ȡ��ǰweb �ĸ�Ŀ¼
 	getContextPath()
 	
 	�ܡ���ȡ��ǰWEB Ӧ��ĳһ���ļ���������
 	getResourceAsStream(String path)  pathΪgetPath(String fileName)��ȡ��Ŀ¼
 	
 	
 	
3).service()��������ε��ã�ÿ�����󶼻����Service()����

4).destory()���ٷ�����ֻ������һ�Σ��ڵ�ǰServlet����webӦ�ñ�ж��ǰ���ã������ͷŵ�ǰServlet���õ���Դ


Servlet��������ServletRequest��װ��������Ϣ�����Ի�ȡ�κ�������Ϣ
				--  java.lang.String 	getParameter(java.lang.String name)����������������ƣ���ȡ����ֵ,ֻ�ܻ�ȡ��һ���ύ��ֵ
				
				--  java.lang.String[] 	getParameterValues(java.lang.String name)����ȡ������������飬�������ж���ύֵ����ѡ��
				
				--  java.util.Enumeration 	getParameterNames() ������������������ֵ�ö�ٶ���
				
				--  java.util.Map 	getParameterMap() ����������������ļ�ֵk-v�ԣ�ֵ��String[] ����
				
				
				
				
			   ServletResponse��װ����Ӧ��Ϣ�����Ը��û���Ӧ
			   
			   --getWriter():����PrintWriter���󣬿��Ը��ͻ��˷�����Ϣ
			   
			   --setContentType(java.lang.String type) ������Ӧ��ʽ MINE TYPE
			   http://www.w3school.com.cn/media/media_mimeref.asp
			   
			   --sendRedirect(java.lang.String location) �ض��򷽷�
			   
	
	
	