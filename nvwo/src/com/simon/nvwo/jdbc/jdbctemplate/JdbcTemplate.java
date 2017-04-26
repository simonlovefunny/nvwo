package com.simon.nvwo.jdbc.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simon.nvwo.jdbc.DBUtil;

public class JdbcTemplate {
	
	private Connection conn;
	
	public JdbcTemplate(Connection conn){
		
		this.conn=conn;
	}
	
	//执行查询并且使用结果处理 R retrieve 检索
	/**
	 * 
	 * @param handler 调用者来提供处理方法
	 */
	public void query(String sql,RowCallBackHandler handler){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(handler!=null){
				
				handler.processRow(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
		
	}
	
	//使用预处理并且使用结果处理 R retrieve 检索
	public void query(String sql,PreparedStatementSetter setter,RowCallBackHandler handler){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			if(setter!=null){
				setter.setValues(pstmt);
			}
			rs=pstmt.executeQuery();
			if(handler!=null){
				handler.processRow(rs);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
	}
	
	//C create  创建数据库
	public void create(String sql,PreparedStatementSetter setter){
		
		PreparedStatement pstmt=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			
			if(setter!=null){
				//通过PreparedStatement设置值来替换占位符“？”
				setter.setValues(pstmt);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
		
		
	}
	
	//U update 
	public void update(String sql,PreparedStatementSetter setter){
		
		PreparedStatement pstmt=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			
			if(setter!=null){
				//通过PreparedStatement设置值来替换占位符“？”
				setter.setValues(pstmt);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
		
		
	}
	
	//D delete
	public void delete(String sql,PreparedStatementSetter setter){
		
		PreparedStatement pstmt=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			
			if(setter!=null){
				//通过PreparedStatement设置值来替换占位符“？”
				setter.setValues(pstmt);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
		
		
	}
	
public void add(String sql,PreparedStatementSetter setter){
		
		PreparedStatement pstmt=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			
			if(setter!=null){
				//通过PreparedStatement设置值来替换占位符“？”
				setter.setValues(pstmt);
			}
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn);
		}
		
		
	}
}
