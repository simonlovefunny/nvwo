package com.simon.nvwo.javaweb.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 
* @ClassName: TestJspFragment
* @Description: ����ǩ��ı�ǩ
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��6�� ����9:05:44
*
 */
public class TestJspFragment extends SimpleTagSupport{

	/* 
	* <p>Title: doTag</p>
	* <p>Description: </p>
	* @throws JspException
	* @throws IOException
	* @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	*/ 
	@Override
	public void doTag() throws JspException, IOException {
			
		JspFragment bodyContent=getJspBody();
		//JspFragment.invoke(java.io.Writer out) Ϊ��ǩ������������ַ���������Ϊnull�������ҳ��	
		
		StringWriter writer=new StringWriter();
		bodyContent.invoke(writer);
		
		//����ǩ��������ݱ�Ϊ��д
		String content=writer.toString().toUpperCase();
		//�����ҳ��,JspContext�����൱��pageContext
		getJspContext().getOut().print(content);
	}
	
	

}
