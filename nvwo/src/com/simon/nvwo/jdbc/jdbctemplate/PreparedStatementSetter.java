package com.simon.nvwo.jdbc.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//通过PreparedStatement设置值来替换占位符“？”
	void setValues(PreparedStatement pstmt) throws SQLException;

}
