package com.simon.nvwo.jdbc.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//ͨ��PreparedStatement����ֵ���滻ռλ��������
	void setValues(PreparedStatement pstmt) throws SQLException;

}
