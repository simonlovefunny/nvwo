package com.simon.nvwo.kit;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

//����Spring-jdbc�Ĺ�����
public class JdbcTemplateUtils {
	
	private static JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	* @Title: jdbcTemplate
	* @Description: ����jdbcTemplat
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
	* @Description: ��������Druid���ӳص�����Դ
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
