package com.simon.nvwo.javaweb.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.simon.nvwo.jdbc.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		//防止中文乱码
		request.setCharacterEncoding("UTF-8");
		//给用户返回html页面
		StringBuilder builder=new StringBuilder();
		builder.append("<html>")
			   .append("<head>")
			   .append("</head>")
			   .append("</html>");
			   
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		String sql="SELECT count(id) from user_info WHERE username=?"
				   +"AND password=?";
		PrintWriter out=response.getWriter();
		try{
			
			conn=DBUtil.open();
			
			statement=conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			resultSet=statement.executeQuery();
			
			if(resultSet.next()){
				
				int count=resultSet.getInt(1);
				
				if(count>0){
					
					out.println("Hello: "+username);
					response.sendRedirect("http://localhost:8080/nvwo/template.jsp?name=simon");
				}else{
					out.println("sorry: "+username);
				}
			}
		
		}catch(SQLException ex){
			
			ex.printStackTrace();
		}finally{
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBUtil.close(conn);
		}
	}
}
