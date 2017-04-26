package com.simon.nvwo.javaweb.shopping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/TokenServlet")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokenServlet() {
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		HttpSession session = request.getSession();
//		Object token = session.getAttribute("token");
//		String tokenValue = request.getParameter("token");
//		System.out.println(token); 
//		System.out.println(tokenValue); 
//
//		if(token != null && token.equals(tokenValue)){
//			session.removeAttribute("token");
//		}else{
//			response.sendRedirect(request.getContextPath() + "/token/token.jsp");
//			return;
//		}
		//检验token是否一致
		boolean valid = TokenProcessor.getInstance().isTokenValid(request);
		if(valid){
			//检验通过，移除用于对比的token
			TokenProcessor.getInstance().resetToken(request);
		}else{
			//检验不通过，重定向回去
			response.sendRedirect(request.getContextPath() + "/form.jsp");
			return;
		}
		//检验通过，执行请求
		String name = request.getParameter("name");
		//访问数据库服务器...
		System.out.println("name: " + name);
		
		//request.getRequestDispatcher("/token/success.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/success.jsp");
	}
}
