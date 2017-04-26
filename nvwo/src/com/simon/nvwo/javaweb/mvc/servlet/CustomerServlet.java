package com.simon.nvwo.javaweb.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;

import com.simon.nvwo.javaweb.mvc.dao.CriteriaCustomer;
import com.simon.nvwo.javaweb.mvc.dao.Customer;
import com.simon.nvwo.javaweb.mvc.dao.CustomerDao;
import com.simon.nvwo.javaweb.mvc.dao.CustomerDaoImpl;

/**
 * 多个请求对应一个Servlet
 * 1.请求url：
 * 添加: customerServlet?method=add
 * 删除: customerServlet?method=delete
 * 查询: customerServlet?method=query
 * 更新：customerServlet?method=update
 * 2.请求url：路由名要和方法名保持一致
 * 添加: addCustomer.do
 * 删除: query.do
 * 查询: delete.do
 * 更新: updateCustomer.do
 * 模糊查询:fuzzyQuery.do
 * @author 昭毅
 *
 */
// 方法1 
//@WebServlet("/customerServlet")
//方法2 
@WebServlet(name="CustomerServlet",urlPatterns="*.do")
public class CustomerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CustomerDao customerDao=new CustomerDaoImpl();

	/* 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	/* 方法2
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String servletPath=req.getServletPath();
		System.out.println("servletPath: "+servletPath);
		String methodName=servletPath.substring(1,servletPath.length()-3);
		System.out.println("methodName: "+methodName);
		try {
			
			Class clazz=Class.forName("com.simon.nvwo.javaweb.mvc.servlet.CustomerServlet");
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
			Method method=clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			/**
			 * @see java.lang.reflect.Method#invoke(Object obj, Object... args)
			 * Object obj被调用方法的类
			 * Object... args按声明顺序标识该方法的形参类型
			 * 调用对应方法
			 */
			method.invoke(clazz.newInstance(), req,resp);
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
		} catch (ClassNotFoundException e) {
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

	/* 方法1
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method=req.getParameter("method");
		
		if(StringUtils.equals(method, "add")){
			
			add(req,resp);
		}else if(StringUtils.equals(method, "delete")){
			delete(req,resp);
		}else if(StringUtils.equals(method, "query")){
			query(req,resp);
		}else if(StringUtils.equals(method, "update")){
			update(req,resp);
		}
	}
	*/
	
	/**
	 * 模糊查询
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Customer> customers=customerDao.getAll();
		
		req.setAttribute("customers", customers);
		
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String idStr=req.getParameter("id");

		int id=0;
		
		try{
			
			id=Integer.parseInt(idStr);
			System.out.println(id);
			customerDao.delete(id);
		}catch(Exception e){
			
		}

		resp.sendRedirect("http://localhost:8080/nvwo/query.do");
	}


	private void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		
		String address=req.getParameter("address");
		
		String phone=req.getParameter("phone");
		
		
		//检验name是否已被占用
		long count=customerDao.getCountByName(name);
		
		if(count > 0){
			
			req.setAttribute("message", "用户名"+name+"已经被占用!");
			req.getRequestDispatcher("/addCustomer.jsp").forward(req, resp);
			return;
		}
		
		Customer customer=new Customer(name, address, phone);
		
		customerDao.save(customer);
		
		resp.sendRedirect("http://localhost:8080/nvwo/success.jsp");
	}
	

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		String forwardPath="/error.jsp";
		
		String idStr=req.getParameter("id");

		
		
		try{
			Customer customer=customerDao.getCustomerById(Integer.parseInt(idStr));
			
			if(customer!=null){
				
				req.setAttribute("customer", customer);
				forwardPath="/updateCustomer.jsp";
			}

		}catch(Exception e){
			
		}

		req.getRequestDispatcher(forwardPath).forward(req, resp);
		
	
	}
	
	/**
	 * 
	 * 
	 * @Title: fuzzyQuery
	 * @Description: 模糊查询
	 * @param req
	 * @param resp    
	 * @return void    返回类型
	 */
	private void fuzzyQuery(HttpServletRequest req, HttpServletResponse resp){
		
		String name=req.getParameter("name");

		String address=req.getParameter("address");

		String phone=req.getParameter("phone");

		CriteriaCustomer criteriaCustomer=new CriteriaCustomer(name, address, phone);
		
		List<Customer> customers=customerDao.getForListWithCriteriaCustomer(criteriaCustomer);
		
		req.setAttribute("customers", customers);
		
		try {
			
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	
	private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	
		String id = req.getParameter("id");
		String name =req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String oldName = req.getParameter("oldName");
		
		//2. 检验 name 是否已经被占用:
		
		//2.1 比较 name 和 oldName 是否相同, 若相同说明 name 可用. 
		//2.1 若不相同, 则调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDao.getCountByName(name);
			//2.2 若返回值大于 0, 则响应 updatecustomer.jsp 页面: 通过转发的方式来响应 newcustomer.jsp
			if(count > 0){
				//2.2.1 在 updatecustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
				//在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!, 
				//在页面上通过 request.getAttribute("message") 的方式来显示
				req.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");
				
				//2.2.2 newcustomer.jsp 的表单值可以回显. 
				//address, phone 显示提交表单的新的值, 而 name 显示 oldName, 而不是新提交的 name
				
				//2.2.3 结束方法: return 
				req.getRequestDispatcher("/updateCustomer.jsp").forward(req, resp);
				return;
			}
		}
		
		//3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id)); 
		
		//4. 调用 CustomerDAO 的  update(Customer customer) 执行更新操作
		customerDao.update(customer);
		
		//5. 重定向到 query.do
		resp.sendRedirect("query.do");
		
		
	}
}
