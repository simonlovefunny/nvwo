package com.simon.nvwo.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
* @ClassName: TestSonTag
* @Description: �ӱ�ǩ
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��7�� ����4:53:54
*
 */
public class TestSonTag extends SimpleTagSupport{

	/* 
	* <p>Title: doTag</p>
	* <p>Description: </p>
	* @throws JspException
	* @throws IOException
	* @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	*/ 
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//��ȡ����ǩ������
		JspTag parent=getParent();
		
		TestparentTag parentTag=(TestparentTag) parent;
		
		String name=parentTag.getName();
		
		System.out.println("�ӱ�ǩ���name: "+name);

	}
		
	
}
