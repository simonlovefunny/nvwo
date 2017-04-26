package com.simon.nvwo.javaweb.filter.permission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}


	/* 
	* <p>Title: getParameter</p>
	* <p>Description: </p>
	* @param name
	* @return
	* @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	*/ 
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		
		String val= super.getParameter(name);
		
		if(val != null &&val.contains("fuck")){
			
			val=val.replace("fuck", "****");
		}
		
		return val;
	}
	
	

}
