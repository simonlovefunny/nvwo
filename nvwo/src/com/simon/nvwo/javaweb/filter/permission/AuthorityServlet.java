package com.simon.nvwo.javaweb.filter.permission;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authorityServlet")
public class AuthorityServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private UserDao userDao=new UserDao();
	
	/* 
	* <p>Title: doGet</p>
	* <p>Description: </p>
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException
	* @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/ 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	/* 
	* <p>Title: doPost</p>
	* <p>Description: </p>
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException
	* @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String methodName=req.getParameter("method");
		try {
			
			//Class clazz=Class.forName("com.simon.nvwo.javaweb.filter.permission.AuthorityServlet");
			/**
			 * @see java.lang.Class<T>#getgetDeclaredMethod(String name,Class<?>... parameterTypes)
			 * ����һ�� Method ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ���������ķ�����
			 * name ������һ�� String����ָ�����跽���ļ�ƣ�
			 * parameterTypes ������ Class �����һ�����飬
			 * ��������˳���ʶ�÷������β����͡�
			 * �����ĳ�����������˴�����ͬ�������͵Ķ��������
			 * ����������һ�������ķ������ͱ����������ķ������Ͷ����⣬
			 * �򷵻ظ÷��������򽫴�����ѡһ��������
			 * ��������� "<init>�� �� ��<clinit>"��������һ�� NoSuchMethodException�� 
			 */
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			/**
			 * @see java.lang.reflect.Method#invoke(Object obj, Object... args)
			 * Object obj�����÷�������
			 * Object... args������˳���ʶ�÷������β�����
			 * ���ö�Ӧ����
			 */
			method.invoke(this.getClass().newInstance(), req,resp);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**
	* @Title:get
	* @Description: ��ȡ�û�����Ӧ��Ȩ��
	* @param @param req
	* @param @param resp    ����
	* @return void    ��������
	* @throws IOException 
	* @throws ServletException 
	 */
	protected void getAuthorities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String username=req.getParameter("username");
		
		User user=userDao.get(username);
		
		req.setAttribute("user", user);
		req.setAttribute("authorities", user.getAuthorities());
		
		req.getRequestDispatcher("/permission/authority-manager.jsp").forward(req, resp);
		
	}
	
	/**
 
	* @Title: updateAuthorities
	* @Description: �����û�Ȩ��
	* @param @param req
	* @param @param resp    ����
	* @return void    ��������
	* @throws IOException 
	 */
	protected void updateAuthorities(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		String username=req.getParameter("username");
		
		String[] authorities=req.getParameterValues("authority");
		
		List<Authority> authoritiesMirror=userDao.getAuthorities(authorities);
		
		userDao.update(username, authoritiesMirror);
		
		resp.sendRedirect(req.getContextPath() + "/authority-manager.jsp");
		
		
	}
	
	

}
