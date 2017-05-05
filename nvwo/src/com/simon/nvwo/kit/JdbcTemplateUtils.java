package com.simon.nvwo.kit;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

//创建Spring-jdbc的工具类
public class JdbcTemplateUtils {
	
	private static JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	* @Title: jdbcTemplate
	* @Description: 返回jdbcTemplat
	* @param @return    jdbcTemplate
	* @return JdbcTemplate    org.springframework.jdbc.core.JdbcTemplate
	* @throws
	 */
	public static JdbcTemplate jdbcTemplate(){
		
        if(jdbcTemplate == null) {
            jdbcTemplate = createJdbcTemplate();
        }
        return jdbcTemplate;
	}
	
	/**
	 * 
	* @Title: createJdbcTemplate
	* @Description: 创建基于Druid连接池的数据源
	* @param @return    dataSource
	* @return JdbcTemplate    org.springframework.jdbc.core.JdbcTemplate
	* @throws
	 */
	private static JdbcTemplate createJdbcTemplate() {

	        DruidDataSource ds = new DruidDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/shiro");
	        ds.setUsername("root");
	        ds.setPassword("root");

	        return new JdbcTemplate(ds);
	}

}
