package com.simon.nvwo.javaweb.shopping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessStep2
 */
@WebServlet("/ProcessStep2")
public class ProcessStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessStep2() {
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
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String cardType=request.getParameter("cardType");
		String card=request.getParameter("card");
		
		Customer customer=new Customer(name, address, cardType, card);
		
		//–≈œ¢¥Ê»Îhttpsession
		HttpSession session=request.getSession();
		session.setAttribute("customer", customer);
		
		response.sendRedirect(request.getContextPath()+"/confirm.jsp");
	}

}
