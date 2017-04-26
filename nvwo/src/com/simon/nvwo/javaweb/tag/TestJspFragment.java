package com.simon.nvwo.javaweb.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 
* @ClassName: TestJspFragment
* @Description: 带标签提的标签
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月6日 下午9:05:44
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
		//JspFragment.invoke(java.io.Writer out) 为标签体内容输出的字符流，设置为null则输出到页面	
		
		StringWriter writer=new StringWriter();
		bodyContent.invoke(writer);
		
		//将标签体输出内容变为大写
		String content=writer.toString().toUpperCase();
		//输出到页面,JspContext可以相当于pageContext
		getJspContext().getOut().print(content);
	}
	
	

}
