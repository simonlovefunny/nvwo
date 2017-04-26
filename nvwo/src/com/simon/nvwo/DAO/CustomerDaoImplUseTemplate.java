package com.simon.nvwo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simon.nvwo.jdbc.DBUtil;
import com.simon.nvwo.jdbc.jdbctemplate.JdbcTemplate;
import com.simon.nvwo.jdbc.jdbctemplate.PreparedStatementSetter;
import com.simon.nvwo.jdbc.jdbctemplate.RowCallBackHandler;

/**
 * 使用@see com.simon.nvwo.jdbc.jdbctemplate.JdbcTemplate实现
 * @author 昭毅
 *
 */
public class CustomerDaoImplUseTemplate implements CustomerDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.open();
		String sql="insert into user_info(id,age,name,password) values(?,?,?,?)";
		jdbcTemplate=new JdbcTemplate(conn);
		

		jdbcTemplate.add(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, customer.getId());
				pstmt.setInt(2, customer.getAge());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getPassword());
			}
		});
			

		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.open();
		String sql="update user_info set id=?,age=?,name=?,password=?";
		jdbcTemplate=new JdbcTemplate(conn);
		

		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, customer.getId());
				pstmt.setInt(2, customer.getAge());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getPassword());
			}
		});
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		Connection conn=DBUtil.open();
			String sql="update user_info set id=?,age=?,name=?,password=?";
			jdbcTemplate=new JdbcTemplate(conn);
				

			jdbcTemplate.delete(sql, new PreparedStatementSetter() {
					
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					// TODO Auto-generated method stub
					pstmt.setInt(1, id);
				}
			});
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub

		Connection conn=DBUtil.open();
		String sql="select age,name,password from user_info where id=?";
		jdbcTemplate=new JdbcTemplate(conn);
		final Customer customer=new Customer();

		jdbcTemplate.query(sql, new PreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, id);
			}
		},new RowCallBackHandler() {
				
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()){

					int age=rs.getInt(1);
					
					String name=rs.getString(2);
					
					String password=rs.getString(3);
					
					customer.setAge(age);
					customer.setId(id);
					customer.setName(name);
					customer.setPassword(password);
				}	
			}
		});
		return customer;
	}

	@Override
	public List<Customer> query() {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.open();
		String sql="select id,age,name,password from user_info";
		jdbcTemplate=new JdbcTemplate(conn);
		final List<Customer> list=new ArrayList<Customer>();

		jdbcTemplate.query(sql,new RowCallBackHandler() {
				
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()){
					
					int id=rs.getInt(1);
					
					int age=rs.getInt(2);
					
					String name=rs.getString(3);
					
					String password=rs.getString(4);
					
					Customer customer=new Customer(id, age, name, password);
					
					list.add(customer);
				}	
			}
		});
		return list;
	}

}
