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
			 * 返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明的方法。
			 * name 参数是一个 String，它指定所需方法的简称，
			 * parameterTypes 参数是 Class 对象的一个数组，
			 * 它按声明顺序标识该方法的形参类型。
			 * 如果在某个类中声明了带有相同参数类型的多个方法，
			 * 并且其中有一个方法的返回类型比其他方法的返回类型都特殊，
			 * 则返回该方法；否则将从中任选一个方法。
			 * 如果名称是 "<init>” 或 “<clinit>"，则引发一个 NoSuchMethodException。 
			 */
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			/**
			 * @see java.lang.reflect.Method#invoke(Object obj, Object... args)
			 * Object obj被调用方法的类
			 * Object... args按声明顺序标识该方法的形参类型
			 * 调用对应方法
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
	* @Description: 获取用户名对应的权限
	* @param @param req
	* @param @param resp    参数
	* @return void    返回类型
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
	* @Description: 更新用户权限
	* @param @param req
	* @param @param resp    参数
	* @return void    返回类型
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
