package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
// @WebServlet("/DemoServlet")ע�����ã���web.xml������һ����Ч��
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/* 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}



	/* 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



	/* 
	 * @see javax.servlet.GenericServlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}



	/* 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		//ServletContext
		ServletContext context=config.getServletContext();
		
		String driverClass=context.getInitParameter("driverclass");
		
		Enumeration<String> paramNames=context.getInitParameterNames();
		
		while(paramNames.hasMoreElements()){

			String name=paramNames.nextElement();
			String value=context.getInitParameter(name);
			System.out.println("init-parameter name: "+name+",value: "+value);
		}
		
		//��ȡ��ǰWEB Ӧ��ĳ���ļ��ľ���·��
		String realPath=context.getRealPath("Image.png");
		System.out.println(realPath);
		
		//��ȡweb �ĸ�Ŀ¼
		String contextPath=context.getContextPath();
		System.out.println(contextPath);
		
		
		try {
			ClassLoader classLoader=getClass().getClassLoader();
			InputStream is=classLoader.getResourceAsStream("jdbc.properties");
			
			System.out.println("1. "+is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			
			InputStream is=context.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			
			System.out.println("2. "+is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ȡinit-parameter
		//���õ�init-parameter���� user
		String user=config.getInitParameter("user");
		//���õ�����init-parameter������ö��
		Enumeration<String> names=config.getInitParameterNames();
		
		while(names.hasMoreElements()){

			String name=names.nextElement();
			String value=config.getInitParameter(name);
			System.out.println("init-parameter name: "+name+",value: "+value);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
