package com.simon.nvwo.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 
* @ClassName: TestparentTag
* @Description:父标签
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月7日 下午4:54:16
*
 */
public class TestparentTag extends SimpleTagSupport{
	
	private String name="nvwo";
	
	public String getName(){
		
		return name;
	}
	
	/* 
	* <p>Title: doTag</p>
	* <p>Description: </p>
	* @throws JspException
	* @throws IOException
	* @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	*/ 
	@Override
	public void doTag() throws JspException, IOException {
		
		System.out.println("父标签的处理器类name: "+name);
		getJspBody().invoke(null);
	}
	
	
		
}
