JSP��EL���ʽ  http://blog.csdn.net/zdwzzu2006/article/details/4672383

	EL �ṩ���� JSP �ű�����Ԫ�ط�Χ��ʹ������ʱ���ʽ�Ĺ��ܡ�
	�ű�����Ԫ����ָҳ�����ܹ������� JSP �ļ���Ƕ�� Java �����Ԫ�ء�
	����ͨ�����ڶ�������Լ�ִ����ЩӰ�����������ݵļ��㡣JSP 
	2.0 �� EL ���ʽ���Ϊһ�ֽű�����Ԫ��
	
	EL�﷨   ${expression}
	  ${ObjectName.����}
	  ���Ȼ�ӵ�ǰҳ����Ѱ��֮ǰ�Ƿ�����ObjectName�����û���ҵ������ε�Request��Session��
	 Application ��Χ��Ѱ�ң�ֱ���ҵ�Ϊֹ�����ֱ�������Ȼû���ҵ�ƥ���
	  �������򷵻�null
	  
	  
	  EL �ṩ��.���͡�[ ]���������������ȡ����  ���Ҫ��̬ȡֵʱ���Ϳ����á�[ ]������������.���޷�������̬ȡֵ
	  ${sessionScope.user[data]}��data ��һ������
	      ��Ҫ��ȡ�����������а���һЩ�����ַ�����.��?�Ȳ�����ĸ�����ֵķ��ţ���һ��Ҫʹ�á�[ ]��
	  ${user.My-Name}Ӧ����Ϊ${user["My-Name"] }
	  
	  
	  ���Է�Χ��EL�е�����
     Page             PageScope
     Request          RequestScope
     Session          SessionScope
     Application      ApplicationScope
         
            �÷�
            
    pageScope
	��ҳ�淶Χ�ı�������ӳ�䵽��ֵ��
	���磬EL ���ʽ����ʹ�� ${pageScope.objectName} ����һ�� JSP ��ҳ�淶Χ�Ķ���
	������ʹ�� ${pageScope.objectName.attributeName} ���ʶ�������ԡ�

	requestScope
	

	������Χ�ı�������ӳ�䵽��ֵ���ö���������������������ԡ�
	���磬EL ���ʽ����ʹ�� ${requestScope.objectName} ����һ�� JSP ����Χ�Ķ���
	������ʹ�� ${requestScope.objectName.attributeName} ���ʶ�������ԡ�

	sessionScope

	���Ự��Χ�ı�������ӳ�䵽��ֵ���ö���������ʻỰ��������ԡ����磺
	${sessionScope.name} 

	applicationScope
	
	��Ӧ�ó���Χ�ı�������ӳ�䵽��ֵ������ʽ�����������Ӧ�ó���Χ�Ķ���

  
           ��ʽ����	 
    pageContext
 	JSP ҳ�������ġ����������ڷ��� JSP ��ʽ������������Ӧ���Ự�������servletContext �ȡ�
 	���磬${pageContext.response}
 	
 	param
	�������������ӳ�䵽�����ַ�������ֵ��ͨ������ ServletRequest.getParameter (String name) ��ã���
	getParameter (String) �������ش����ض����ƵĲ�����
	���ʽ $(param.name) �൱�� request.getParameter (name)��
	
	paramValues
	�������������ӳ�䵽һ����ֵ���飨ͨ������ ServletRequest.getParameter (String name) ��ã���
	���� param ��ʽ����ǳ����ƣ���������һ���ַ�����������ǵ���ֵ��
	���ʽ ${paramvalues.name) �൱�� request.getParamterValues(name)��
	
	header
	������ͷ����ӳ�䵽�����ַ���ͷֵ��ͨ������ ServletRequest.getHeader(String name) ��ã���
	���ʽ ${header.name} �൱�� request.getHeader(name)��
	
	headerValues
	������ͷ����ӳ�䵽һ����ֵ���飨ͨ������ ServletRequest.getHeaders(String) ��ã�������ͷ��ʽ����ǳ����ơ�
	���ʽ ${headerValues.name} �൱�� request.getHeaderValues(name)��
 	
 	cookie
 	�� cookie ����ӳ�䵽���� cookie ����������������Ŀͻ���������Ի��һ������ cookie�����ʽ ${cookie.name.value} ���ش����ض����Ƶĵ�һ�� cookie ֵ��
 	�������������ͬ���� cookie����Ӧ��ʹ�� ${headerValues.name} ���ʽ
 	
 	initParam 	�������ĳ�ʼ����������ӳ�䵽����ֵ��ͨ������ ServletContext.getInitparameter(String)
 	
 	<%@ page isELIgnored="true" %> ��ʾ�Ƿ����EL����,TRUE��ʾ��ֹ.FALSE��ʾ����ֹ.JSP2.0��Ĭ�ϵ�����EL���ԡ�
 	
 	��spring �У������߼�����Ԫ���صĽ�����ݣ�������ΪAttribute ����
	�õ�HttpServletRequest �����з��أ�����ʵ�ֿɲμ�Spring Դ����
	org.springframework.web.servlet.view.InternalResourceView.
	exposeModelAsRequestAttributes������ʵ�ִ��룩SpringMVC �У�������ݶ���Ĭ�϶���requestScope
	
EL�Զ��庯��
	��дJaVa��̬��;�̬����