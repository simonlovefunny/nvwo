package com.simon.nvwo.jdbc.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowCallBackHandler {
	//��������
	void processRow(ResultSet rs) throws SQLException;

}
