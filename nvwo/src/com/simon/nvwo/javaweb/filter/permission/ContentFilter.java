package com.simon.nvwo.javaweb.filter.permission;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simon.nvwo.javaweb.filter.HttpFilter;

public class ContentFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		

		HttpServletRequest req = new MyHttpServletRequest(request);
		
		filterChain.doFilter(req, response);

	}

}
