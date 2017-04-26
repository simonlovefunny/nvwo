package com.simon.nvwo.javaweb.checkcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCode
 */
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ��ȡ�������: CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		
		//2. ��ȡ session �е� CHECK_CODE_KEY ����ֵ
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
		
		System.out.println(paramCode);
		System.out.println(sessionCode); 
		
		//3. �ȶ�. ���Ƿ�һ��, ��һ��˵����֤����ȷ, ����һ��, ˵����֤�����
		if(!(paramCode != null && paramCode.equalsIgnoreCase(sessionCode))){
			request.getSession().setAttribute("message", "��֤�벻һ��!");
			response.sendRedirect(request.getContextPath() + "/checkcode.jsp");
			return;
		}
		
		System.out.println("��������!");
		
	}
	

}
