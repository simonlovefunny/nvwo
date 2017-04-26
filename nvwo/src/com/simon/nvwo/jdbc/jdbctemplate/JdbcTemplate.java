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
	
	//ִ�в�ѯ����ʹ�ý������ R retrieve ����
	/**
	 * 
	 * @param handler ���������ṩ������
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
	
	//ʹ��Ԥ������ʹ�ý������ R retrieve ����
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
	
	//C create  �������ݿ�
	public void create(String sql,PreparedStatementSetter setter){
		
		PreparedStatement pstmt=null;
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			
			if(setter!=null){
				//ͨ��PreparedStatement����ֵ���滻ռλ��������
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
				//ͨ��PreparedStatement����ֵ���滻ռλ��������
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
				//ͨ��PreparedStatement����ֵ���滻ռλ��������
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
				//ͨ��PreparedStatement����ֵ���滻ռλ��������
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
