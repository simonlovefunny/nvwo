package com.simon.nvwo.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.simon.nvwo.jdbc.DBUtil;

public class DBUtilTest {



	@Test
	public void testGetConnection() throws SQLException {
		
		Connection conn=DBUtil.getConnection();
		
		System.out.println();
	}

}
