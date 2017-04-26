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
 * ��������Ӧһ��Servlet
 * 1.����url��
 * ���: customerServlet?method=add
 * ɾ��: customerServlet?method=delete
 * ��ѯ: customerServlet?method=query
 * ���£�customerServlet?method=update
 * 2.����url��·����Ҫ�ͷ���������һ��
 * ���: addCustomer.do
 * ɾ��: query.do
 * ��ѯ: delete.do
 * ����: updateCustomer.do
 * ģ����ѯ:fuzzyQuery.do
 * @author ����
 *
 */
// ����1 
//@WebServlet("/customerServlet")
//����2 
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

	/* ����2
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
			 * ����һ�� Method ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ���������ķ�����
			 * name ������һ�� String����ָ�����跽���ļ�ƣ�
			 * parameterTypes ������ Class �����һ�����飬
			 * ��������˳���ʶ�÷������β����͡�
			 * �����ĳ�����������˴�����ͬ�������͵Ķ��������
			 * ����������һ�������ķ������ͱ����������ķ������Ͷ����⣬
			 * �򷵻ظ÷��������򽫴�����ѡһ��������
			 * ��������� "<init>�� �� ��<clinit>"��������һ�� NoSuchMethodException�� 
			 */
			Method method=clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			/**
			 * @see java.lang.reflect.Method#invoke(Object obj, Object... args)
			 * Object obj�����÷�������
			 * Object... args������˳���ʶ�÷������β�����
			 * ���ö�Ӧ����
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

	/* ����1
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
	 * ģ����ѯ
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
		
		
		//����name�Ƿ��ѱ�ռ��
		long count=customerDao.getCountByName(name);
		
		if(count > 0){
			
			req.setAttribute("message", "�û���"+name+"�Ѿ���ռ��!");
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
	 * @Description: ģ����ѯ
	 * @param req
	 * @param resp    
	 * @return void    ��������
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
		
		//2. ���� name �Ƿ��Ѿ���ռ��:
		
		//2.1 �Ƚ� name �� oldName �Ƿ���ͬ, ����ͬ˵�� name ����. 
		//2.1 ������ͬ, ����� CustomerDAO �� getCountWithName(String name) ��ȡ name �����ݿ����Ƿ����
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDao.getCountByName(name);
			//2.2 ������ֵ���� 0, ����Ӧ updatecustomer.jsp ҳ��: ͨ��ת���ķ�ʽ����Ӧ newcustomer.jsp
			if(count > 0){
				//2.2.1 �� updatecustomer.jsp ҳ����ʾһ��������Ϣ: �û��� name �Ѿ���ռ��, ������ѡ��!
				//�� request �з���һ������ message: �û��� name �Ѿ���ռ��, ������ѡ��!, 
				//��ҳ����ͨ�� request.getAttribute("message") �ķ�ʽ����ʾ
				req.setAttribute("message", "�û���" + name + "�Ѿ���ռ��, ������ѡ��!");
				
				//2.2.2 newcustomer.jsp �ı�ֵ���Ի���. 
				//address, phone ��ʾ�ύ�����µ�ֵ, �� name ��ʾ oldName, ���������ύ�� name
				
				//2.2.3 ��������: return 
				req.getRequestDispatcher("/updateCustomer.jsp").forward(req, resp);
				return;
			}
		}
		
		//3. ����֤ͨ��, ��ѱ�������װΪһ�� Customer ���� customer
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id)); 
		
		//4. ���� CustomerDAO ��  update(Customer customer) ִ�и��²���
		customerDao.update(customer);
		
		//5. �ض��� query.do
		resp.sendRedirect("query.do");
		
		
	}
}
