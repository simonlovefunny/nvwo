JSP�Զ����ǩ  �����com.simon.nvwo.javaweb.tag.HelloSimpleTag
	
	��ǩ��Ӧ�ڱ�ǩ������
	
	�򵥱�ǩ�ӿ�  javax.servlet.jsp.tagext.SimpleTag
	
	��WEB-INF�´���xx.tld�ļ���Ϊ��ǩ��������ļ���/WEB-INF/mytag.tld)
	
	ÿһ����ǩ��Ҫ��Ӧ��ʵ����  com.simon.nvwo.javaweb.tag.HelloSimpleTag--<nvwo:hello/>
��ǩ�� 
	<!-- ʹ�ô��б�ǩ��ı�ǩ -->
	<nvwo:body>hello</nvwo:body>	
	��ǩ��������˱�ǩ��<body-content>scriptless/JSP/tagdependent</body-content>,JSP��������setJspBody����
	������JspFrament���ݸ���ǩ�������࣬getJspBody()���Ի�ȡJspFrament
	
	JspFrament.invoke(null)���������ǩ��
	
	scriptless ��ǩ����԰���EL���ʽ��JSP����Ԫ�أ����ܰ���JSP�ű�Ԫ��
	
	tagdependent ֱ�ӽ������ҳ�棬��ʹ��ELҲ���ᴦ��
	
	JSP	��ǩ����԰���JSP����Ԫ��
	
	JSP����Ԫ��
    <jsp: include>
    <jsp: param>/<jsp: params>
    <jsp: forward>
    <jsp: useBean>
    <jsp: setProperty>��<jsp:getProperty>
    
	����ǩ
	<!-- �ӱ�ǩ��ӡ����ǩ��name����,�ӱ�ǩ��Ϊ����ǩ�ı�ǩ����� -->
	<nvwo:paretnTag>		
	<nvwo:sonTag></nvwo:sonTag>		
	</nvwo:paretnTag>	
	�ӱ�ǩ(�̳�javax.servlet.jsp.tagext.SimpleTagSupport)���Ի�ȡ����ǩ������ getParent()
	����ǩ�޷���ȡ�ӱ�ǩ�����ã������ӱ�ǩ��Ϊ��ǩ��ʹ��
	
	