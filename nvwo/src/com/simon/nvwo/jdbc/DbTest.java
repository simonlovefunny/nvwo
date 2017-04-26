package com.simon.nvwo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {
	
	public static void main(String[] args) {
		
		
		//基本JDBC示例
		/*Connection conn=DBUtil.open();
		
		String sql="select id,age,name,password from user_info";
		
		try{
			
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				
				int id=rs.getInt(1);
				
				int age=rs.getInt(2);
				
				String name=rs.getString(3);
				
				String password=rs.getString(4);
				
				System.out.println(id+","+age+","+name+","+password);
			}
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}*/
		
	}
	
	
	//调用存储过程示例
	private static void query(){
		
		Connection conn=DBUtil.open();
		
		try{
			
			CallableStatement cstmt=conn.prepareCall("{call all_customers()}");
			ResultSet rs=cstmt.executeQuery();
			
			while(rs.next()){
				
				int id=rs.getInt(1);
				
				int age=rs.getInt(2);
				
				String name=rs.getString(3);
				
				String password=rs.getString(4);
				
				System.out.println(id+","+age+","+name+","+password);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}
	//预定义语句示例
	private static void insert(int id,int age,String name,String password){
		
		Connection conn=DBUtil.open();
		String sql="insert into user_info(id,age,name,password) values(?,?,?,?)";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, age);
			pstmt.setString(3, name);
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}
	
	//Jdbc删除示例
	private static void delete(){
		
		Connection conn=DBUtil.open();
		String sql="delete from user_info where id=3";
		
		try{
			
			Statement stmt=conn.createStatement();
			stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}
	//Jdbc更新示例
	private static void update(){
		
		Connection conn=DBUtil.open();
		String sql="update  user_info set name=json where id=3";
		
		try{
			
			Statement stmt=conn.createStatement();
			stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}
	
	//插入示例
	private static void inset(){
		Connection conn=DBUtil.open();
		String sql="insert into user_info(id,age,name,password) values(4,5,'koko','123');";
		
		try{
			
			Statement stmt=conn.createStatement();
			stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}
}
