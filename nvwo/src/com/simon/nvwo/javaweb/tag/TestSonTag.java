package com.simon.nvwo.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
* @ClassName: TestSonTag
* @Description: 子标签
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月7日 下午4:53:54
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
		//获取父标签的引用
		JspTag parent=getParent();
		
		TestparentTag parentTag=(TestparentTag) parent;
		
		String name=parentTag.getName();
		
		System.out.println("子标签输出name: "+name);

	}
		
	
}
