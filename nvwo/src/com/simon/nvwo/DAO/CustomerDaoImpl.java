package com.simon.nvwo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simon.nvwo.jdbc.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void add(Customer customer) {
		Connection conn=DBUtil.open();
		String sql="insert into user_info(id,age,name,password) values(?,?,?,?)";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getId());
			pstmt.setInt(2, customer.getAge());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		
	}

	@Override
	public void update(Customer customer) {
		Connection conn=DBUtil.open();
		String sql="update user_info set id=?,age=?,name=?,password=?";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getId());
			pstmt.setInt(2, customer.getAge());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
	}

	@Override
	public void delete(int id) {
		Connection conn=DBUtil.open();
		String sql="delete from  user_info where id=?";
		
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
	public Customer getCustomerById(int id) {
		Connection conn=DBUtil.open();
		String sql="select age,name,password from user_info where id=?";
		
		try{
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			Customer customer=null;
			while(rs.next()){

				int age=rs.getInt(1);
				
				String name=rs.getString(2);
				
				String password=rs.getString(3);
				
				customer=new Customer(id, age, name, password);
			}
			
			return customer;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		return null;
	}

	@Override
	public List<Customer> query() {
		Connection conn=DBUtil.open();
		String sql="select id,age,name,password from user_info";
		
		List<Customer> list=new ArrayList<Customer>();
		try{
			Statement  stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				
				int id=rs.getInt(1);
				
				int age=rs.getInt(2);
				
				String name=rs.getString(3);
				
				String password=rs.getString(4);
				
				Customer customer=new Customer(id, age, name, password);
				
				list.add(customer);
				
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
