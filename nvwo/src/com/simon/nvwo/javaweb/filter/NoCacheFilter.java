package com.simon.nvwo.javaweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* @ClassName: NoCacheFilter
* @Description: 禁用页面的cache
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月7日 下午8:07:42
*
 */
// @WebFilter("/NoCacheFilter")
public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		System.out.println("cacheFilter's doFilter..");
		
		//禁用cache的方法
		response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//设置页面编码为UTF-8
		request.setCharacterEncoding("UTF-8");
		filterChain.doFilter(request, response);
	}

	

}
