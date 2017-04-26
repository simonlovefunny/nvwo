package com.simon.nvwo.javaweb.mvc.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simon.nvwo.javaweb.mvc.dao.Student;
import com.simon.nvwo.javaweb.mvc.dao.StudentDaoImpl;

/**
 * Servlet implementation class ListAllStudentServlet
 */
@WebServlet("/listAllStudents")
public class ListAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllStudentServlet() {
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
		
		//从数据库获取所有的学生信息
		StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		List<Student> students=studentDaoImpl.query();
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("/students.jsp").forward(request, response);
	}

}
