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
* @ClassName: HttpFilter
* @Description: �Զ���httpfilter
* @author zhaoyi 1508108406@qq.com
* @date 2017��4��7�� ����6:39:48
*
 */
public  abstract class HttpFilter implements Filter {

	/**
	 * ���ڱ��� FilterConfig ����. 
	 */
	private FilterConfig filterConfig;
	
	/**
	 * ����������ֱ�Ӹ���. ��ֱ�Ӹ���, �����ܻᵼ�� filterConfig ��Ա������ʼ��ʧ��
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}

	/**
	 * ������̳еĳ�ʼ������. ����ͨ�� getFilterConfig() ��ȡ FilterConfig ����. 
	 */
	protected void init() {}

	/**
	 * ֱ�ӷ��� init(ServletConfig) �� FilterConfig ����
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	/**
	 * ԭ���� doFilter ����, �ڷ����ڲ��� ServletRequest �� ServletResponse 
	 * תΪ�� HttpServletRequest �� HttpServletResponse, �������� 
	 * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	 * 
	 * ����д Filter �Ĺ��˷���������ֱ�Ӽ̳и÷���. ������̳�
	 * doFilter(HttpServletRequest request, HttpServletResponse response, 
	 *		FilterChain filterChain) ����
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		doFilter(request, response, chain);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws IOException, ServletException;


	@Override
	public void destroy() {}



}
