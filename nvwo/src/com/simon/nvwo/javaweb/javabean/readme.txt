Jsp��ʹ��JavaBean

	<jsp:useBean>��ǩ
	
	JavaBeanʵ������Ҫ���޲εĹ�����
	
	����JavaBean����
	
	<jsp:useBean id="id" class="bean �������" scope="bean ������">	</jsp:useBean>
   		<jsp:setProperty name="bean �� id" property="������"  
                    value="value"/>
   		<jsp:getProperty name="bean �� id" property="������"/>


	
	JavaBean��������
	
	Ĭ��Ϊpage�����û����ʵ�ǰҳ��ʱ��Ч����ҳ����ת��JavaBean������
	
	��ѡ� request  session  application
	
	�ͻ�ÿ���������jspҳ��ʱ�����ᴴ���µ�javabean����Javabean�������Ч��ΧΪ��


	request 
	1.�ͻ�������ʵĵ�ǰjsp��ҳ��
	
	2.�͵�ǰ��ҳ����һ���ͻ��������ҳ������ǰjsp��ҳ��<%@include %>ָ���Լ�<forward>��ǰ���������jsp�ļ�
	
	3.�����й���ͬһ���ͻ������jspҳ��ִ����ϲ���ͻ��˷�����Ӧʱ��javabean��������������ڡ�
	
	4.javabean������Ϊ���Ա�����httpRequest�����У�������javabean��id,����ֵΪjavabean������˿���ͨ��HttpRequest.getAttribute()����ȡ��javabean����
	
	session
	1.Javabean���󱻴�����������������session�����������ڣ��ָ�session�е�jsp�ļ��������javabean����
	
	2.javabean������Ϊ���Ա�����HttpSession�����У�������Ϊjavabean��id,����ֵΪjavabean���󡣳��˿���ͨ��javabean��idֱ������javabean�����⣬Ҳ����ͨ��HttpSession.getAttribute��������ȡ��javabean����
	
	application
	1.javabean���󱻴�����������������webӦ�õ����������ڣ�webӦ���е�����jsp�ļ����ܹ���ͬһ��javabean����

	2.javabean������Ϊ���Ա�����application�����У�������Ϊjavabean��id������ֵΪjavabean���󣬳��˿���ͨ��javabean��idֱ�����ö����⣬Ҳ����ͨ��javabean��application.getAttribute()����ȡ��javabean����	 