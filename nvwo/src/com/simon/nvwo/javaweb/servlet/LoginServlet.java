package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//request����
		//��ȡ�ύ��ֵ
		String user=request.getParameter("user");
		System.out.println(user);
		
		//��ȡ�ύ�Ķ�ѡֵ
		String[] interestring=request.getParameterValues("interestring");
		//��ӡ����
		for(String str: interestring){
			System.out.println(str);	
		}
		//��ȡ�ύ��ֵ��map
/*		Map<String,String[]> map=request.getParameterMap();
		
		for(Map.Entry<String, String[]> entry:map.entrySet()){
			
			System.out.println(entry.getKey()+" : "+Arrays.asList(entry.getValue()));
		}*/
		
		//response����
		
		//������Ӧ��Ϣ
		PrintWriter out=response.getWriter();
		out.println("success");
		//������Ӧ���ض���
		//response.sendRedirect("http://localhost:8080/Eva/login.html");
		//������Ӧ����������
		//response.setContentType("application/msword");
	}

}
