package com.simon.nvwo.javaweb.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 
* @ClassName: LoginFilter
* @Description: 过滤没有登录用户
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月7日 下午8:22:24
*
 */
public class LoginFilter extends HttpFilter {
	//获取sesiionKey，redirectUrl,uncheckedUrl
	private String sesiionKey;
	private String redirectUrl;
	private String uncheckedUrl;
	
	

	/*
	* <p>Title: init</p>
	* <p>Description: </p>
	* @param filterConfig
	* @throws ServletException
	* @see com.simon.nvwo.javaweb.filter.HttpFilter#init(javax.servlet.FilterConfig)
	*/ 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		super.init(filterConfig);
		ServletContext servletContext=filterConfig.getServletContext();
		
		//获取web.xml配置的context-param
		
		uncheckedUrl=servletContext.getInitParameter("uncheckedUrls");
		sesiionKey=servletContext.getInitParameter("sesiionKey");
		redirectUrl=servletContext.getInitParameter("redirectUrl");
		
	}



	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//配置管理
		FilterConfig filterConfig=getFilterConfig();
		
		
		//http://localhost:8080/nvwo/filter/login.jsp	
		String requestUrl=request.getRequestURL().toString();
		// /nvwo/filter/login.jsp
		String requestUri=request.getRequestURI();
		// /filter/login.jsp
		String requestPath=request.getServletPath();
		
		//检查url是否需要验证
	

		String[] uncheckedUrls=uncheckedUrl.split(",");
		
		if(Arrays.asList(uncheckedUrls).contains(requestPath)){
			
			filterChain.doFilter(request, response);
			return;
		}
		//检验用户是否登录
		
		String username=(String) request.getAttribute("usename");
		
		if(username != null && !username.trim().equals("")){

			filterChain.doFilter(request, response);
		}else{
			
			response.sendRedirect("login.jsp");
		}
		
		
	}


}
