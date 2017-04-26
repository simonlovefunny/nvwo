package com.simon.nvwo.DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.simon.nvwo.jdbc.DBUtil;

/**
 * ���з��͵�Dao�����࣬������Dao����Լ̳����������
 * ��ǰDao���߱����ֱ�ӻ�ȡ���ݿ�����
 * @author ����
 *
 * @param <T>
 */
public class Dao<T>{
	
	private QueryRunner queryRunner=new QueryRunner();
	
	protected Class<T> clazz;
	
	
	
	public Dao() {
		
		//FIXME �������
		Type superClass=getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType){
			
			ParameterizedType parameterizedType=(ParameterizedType) superClass;
			
			Type[]  typeArgs=parameterizedType.getActualTypeArguments();
			
			if(typeArgs!=null && typeArgs.length>0){
				
				if(typeArgs[0] instanceof Class){
					
					clazz=(Class<T>)typeArgs[0];
				}
				
			}
		}
	}

	/**
	 * ���ض�Ӧ�ֶε�ֵ
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E>E getForValue(String sql,Object... args){
		
		Connection connection=null;
		
		try{
			
			connection=DBUtil.getConnection();
			return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			DBUtil.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * ����T��Ӧ��List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object... args){
		
		Connection connection=null;
		
		try{
			
			connection=DBUtil.getConnection();
			return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			DBUtil.releaseConnection(connection);
		}
		
		return null;
	}
	/**
	 * �˷�����װ��INSERT��DELETE��UPDATE����
	 * @param sql
	 * @param entity
	 */
	public  void update(String sql,Object...args){
		
		Connection connection=null;
		
		try{
			
			connection=DBUtil.getConnection();
			queryRunner.update(connection, sql, args);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			DBUtil.releaseConnection(connection);
		}
		
	}
	/**
	 * ��ѯ���������ض�Ӧ��T��ʵ�����
	 * @param sql
	 * @param args
	 * @return
	 */
	public T query(String sql,Object...args){
		Connection connection=null;
		
		try{
			
			connection=DBUtil.getConnection();
			return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			DBUtil.releaseConnection(connection);
		}
		
		return null;
	}

}
