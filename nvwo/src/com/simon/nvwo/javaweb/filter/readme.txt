Filter: ������

1). Filter ��ʲô ?

��. JavaWEB ��һ����Ҫ���, ���ԶԷ��͵� Servlet �������������, ������ӦҲ��������. 
��. Filter ��ʵ���� Filter �ӿڵ� Java ��.
��. Filter ��Ҫ�� web.xml �ļ��н������ú�ӳ��. 

2). ��δ���һ�� Filter, ������������

��. ����һ�� Filter ��: ʵ�� Filter �ӿ�: public class HelloFilter implements Filter
��. �� web.xml �ļ������ò�ӳ��� Filter. ���� url-pattern ָ���� Filter ����������Щ��Դ, ������ͨ����Щ url ���ʵ��� Filter

<!-- ע�� Filter -->
  <filter>
  
  <filter-name>httpFilter</filter-name>
  <filter-class>com.simon.nvwo.javaweb.filter.HttpFilter</filter-class>
  
  </filter>
  
  <filter-mapping>
  
  <filter-name>httpFilter</filter-name>
  <!--Filter���ص�url-->
  <url-pattern>*</url-pattern>
  
  
  
 <!-- dispatcher �ڵ�����ã�ָ����һ�ַ���web��Դ�ķ�ʽ�ᱻ���� �����磨ָ��ΪFORWARD���ͻ�����һ����Forward��ʽ������ 
            ��ѡ��ֵ��ERROR,REQUEST(Ĭ��),INCLUDE,FORWARD 
            -->
  <dispatcher>REQUEST</dispatcher>
  </filter-mapping>
  
* FilterChain: Filter ��. ��� Filter ���Թ���һ�� Filter ��. 	
		
			- doFilter(ServletRequest request, ServletResponse response): �����󴫸� Filter ������һ�� Filter,
			����ǰ Filter �� Filter �������һ�� Filter, �����������Ŀ�� Serlvet(�� JSP)	
			
			- ��� Filter ���ص�˳��� <filter-mapping> ���õ�˳���й�, ��ǰ���ȱ�����. 
			
3). <dispatcher> Ԫ��: ָ�������������ص���Դ�� Servlet �������õķ�ʽ��
������REQUEST,INCLUDE,FORWARD��ERROR֮һ��Ĭ��REQUEST. 
�������ö��<dispatcher> ��Ԫ������ָ�� Filter ����Դ�Ķ��ֵ��÷�ʽ��������

��. REQUEST�����û�ֱ�ӷ���ҳ��ʱ��Web����������ù����������Ŀ����Դ��ͨ��RequestDispatcher��include()��forward()��������ʱ����ô�ù������Ͳ��ᱻ���á�

ͨ�� GET �� POST ����ֱ�ӷ��ʡ� 

��. FORWARD�����Ŀ����Դ��ͨ��RequestDispatcher��forward()��������ʱ����ô�ù������������ã�����֮�⣬�ù��������ᱻ���á�

�� <jsp:forward page="/..." /> �� ͨ�� page ָ��� errorPage ת��ҳ��. <%@ page errorPage="test.jsp" %>

��. INCLUDE�����Ŀ����Դ��ͨ��RequestDispatcher��include()��������ʱ����ô�ù������������á�����֮�⣬�ù��������ᱻ���á�

�� <jsp:include file="/..." />

��. ERROR�����Ŀ����Դ��ͨ������ʽ�쳣������Ƶ���ʱ����ô�ù������������á�����֮�⣬���������ᱻ���á�

�� web.xml �ļ���ͨ�� error-page �ڵ��������:

<error-page>
	<exception-type>java.lang.ArithmeticException</exception-type>
	<location>/test.jsp</location>
</error-page>

<filter-mapping>
	<filter-name>secondFilter</filter-name>
	<url-pattern>/test.jsp</url-pattern>
	<dispatcher>REQUEST</dispatcher>
	<dispatcher>FORWARD</dispatcher>
	<dispatcher>INCLUDE</dispatcher>
	<dispatcher>ERROR</dispatcher>
</filter-mapping>
	
