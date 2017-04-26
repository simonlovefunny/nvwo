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
* @Description: 简单标签@seejavax.servlet.jsp.tagext.SimpleTag 实现demo
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月6日 下午4:58:45
*
 */
public class HelloSimpleTag implements SimpleTag {
	
	//JspContext是PageContext的子类
	private PageContext pageContext;
	
	private String value;
	
	private String count;
	
	//一定会被JSP引擎调用，先于doTag()先把JSP的pageContext传给标签处理器类
	@Override
	public void setJspContext(JspContext arg0) {
		
		//System.out.println(arg0 instanceof  PageContext);
		this.pageContext=(PageContext) arg0;
	}
	
	/**
	 * 标签体的逻辑编写到doTag()方法中
	 * JSP页面可以实现的方法都可以在标签中完成
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
/*		//页面输出HelloWorld!
		pageContext.getOut().print("HelloWorld!");
		//获取页面请求
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		
		//设置属性
		System.out.println("value: "+value+",count: "+count);
		System.out.println("doTag");*/
		//页面打印value的值count次
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
