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
* @Description: ����ҳ���cache
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��7�� ����8:07:42
*
 */
// @WebFilter("/NoCacheFilter")
public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		System.out.println("cacheFilter's doFilter..");
		
		//����cache�ķ���
		response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//����ҳ�����ΪUTF-8
		request.setCharacterEncoding("UTF-8");
		filterChain.doFilter(request, response);
	}

	

}
