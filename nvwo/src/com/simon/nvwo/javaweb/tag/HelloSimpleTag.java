package com.simon.nvwo.javaweb.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 
* @ClassName: HelloSimpleTag
* @Description: �򵥱�ǩ@seejavax.servlet.jsp.tagext.SimpleTag ʵ��demo
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��6�� ����4:58:45
*
 */
public class HelloSimpleTag implements SimpleTag {
	
	//JspContext��PageContext������
	private PageContext pageContext;
	
	private String value;
	
	private String count;
	
	//һ���ᱻJSP������ã�����doTag()�Ȱ�JSP��pageContext������ǩ��������
	@Override
	public void setJspContext(JspContext arg0) {
		
		//System.out.println(arg0 instanceof  PageContext);
		this.pageContext=(PageContext) arg0;
	}
	
	/**
	 * ��ǩ����߼���д��doTag()������
	 * JSPҳ�����ʵ�ֵķ����������ڱ�ǩ�����
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
/*		//ҳ�����HelloWorld!
		pageContext.getOut().print("HelloWorld!");
		//��ȡҳ������
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		
		//��������
		System.out.println("value: "+value+",count: "+count);
		System.out.println("doTag");*/
		//ҳ���ӡvalue��ֵcount��
		JspWriter out=pageContext.getOut();
		
		int c=0;
		
		c=Integer.parseInt(count);
		
		for(int i=0;i<c;i++){
			
			out.print(value);
			out.print("<br>");
		}
		
		
		
		
		
	}

	@Override
	public JspTag getParent() {
		
		System.out.println("getParent");
		return null;
	}
	
	
	
	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
