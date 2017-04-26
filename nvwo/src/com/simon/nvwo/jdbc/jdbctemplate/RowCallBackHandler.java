package com.simon.nvwo.jdbc.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowCallBackHandler {
	//处理结果集
	void processRow(ResultSet rs) throws SQLException;

}
