package com.simon.nvwo.javaweb.mvc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.simon.nvwo.jdbc.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void add(Student student) {
		Connection conn=DBUtil.open();
		String sql="insert into user_info(id,type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setInt(2, student.getType());
			pstmt.setString(3, student.getIdCard());
			pstmt.setString(4, student.getExamCard());
			pstmt.setString(5, student.getStudentName());
			pstmt.setString(6, student.getLocation());
			pstmt.setInt(7, student.getGrade());
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		
	}

	@Override
	public void update(Student student) {
		
		Connection conn=DBUtil.open();
		String sql="update student_info set id=?,type=?,id_card=?,exam_card=?,student_name=?,location=?,grade=?";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setInt(2, student.getType());
			pstmt.setString(3, student.getIdCard());
			pstmt.setString(4, student.getExamCard());
			pstmt.setString(5, student.getStudentName());
			pstmt.setString(6, student.getLocation());
			pstmt.setInt(7, student.getGrade());
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		Connection conn=DBUtil.open();
		String sql="delete from  student_info where id=?";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		
	}

	@Override
	public Student getStudentById(int id) {
		
		Connection conn=DBUtil.open();
		String sql="select type,id_card,exam_card,student_name,location,grade from student_info where id=?";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			Student student=null;
			while(rs.next()){
				
				int type=rs.getInt(2);
				
				String idCard=rs.getString(3);
				
				String examCard=rs.getString(4);
				
				String studentName=rs.getString(5);

				String location=rs.getString(6);
				
				int grade=rs.getInt(7);
				
				student=new Student(id, type, idCard, examCard, studentName, location, grade);
				
			}
			
			return student;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		return null;
	}

	@Override
	public List<Student> query() {
		
		Connection conn=DBUtil.open();
		String sql="select id,type,id_card,exam_card,student_name,location,grade from student_info";
		
		List<Student> list=new ArrayList<Student>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				
				int id=rs.getInt(1);
				
				int type=rs.getInt(2);
				
				String idCard=rs.getString(3);
				
				String examCard=rs.getString(4);
				
				String studentName=rs.getString(5);

				String location=rs.getString(6);
				
				int grade=rs.getInt(7);
				
				Student student=new Student(id, type, idCard, examCard, studentName, location, grade);
				
				list.add(student);
				
			}
			
			return list;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{

			DBUtil.close(conn);
			
		}
		return null;
	}



}
