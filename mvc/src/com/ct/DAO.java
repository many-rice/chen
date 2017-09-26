package com.ct;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;



/**
 * 
 * @author Chen-PC
 *
 *封装哦啦基本的CRUD的方法，以供子类继承使用
 *当前DAO直接在方法中获取数据库连接。
 *整个DAO采取dbutils结局方案
 * @param <T>当前DAO处理的实体类型是什么
 */
public class DAO<T> {
	
	private QueryRunner queryRunner=new QueryRunner();
	
	private Class<T> clazz;
	
	public DAO() {
		Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType=(ParameterizedType) superClass;
			
			Type [] typeArgs=parameterizedType.getActualTypeArguments();
			if(typeArgs !=null && typeArgs.length>0) {
				if(typeArgs[0] instanceof Class) {
					clazz=(Class<T>) typeArgs[0];
				}
			}
		}
	}
	
	
	/**
	 * 返回某一个字段的值：例如返回一条记录的customername
	 * @param sql
	 * @param args
	 * @return
	 */
	public long getForValue(String sql,Object ...args) {
		Connection connection=null;
		try {
			connection =JdbcUtils.getConnection();
			return queryRunner.query(connection, sql,new ScalarHandler(),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return 0;
	}
	
	/*
	 * 返回对应的list
	 */
	public List<T> getForList(String sql,Object ...args ){
		Connection connection=null;
		try {
			connection =JdbcUtils.getConnection();
			return queryRunner.query(connection, sql,new BeanListHandler<>(clazz),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/*
	 * 放回对应T的一个实体类对象
	 */
	public T get(String sql,Object ... args) {
		Connection connection=null;
		try {
			connection =JdbcUtils.getConnection();
			return queryRunner.query(connection, sql,new BeanHandler<>(clazz),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/*
	 * 该方法封装了INSERT,DELETE,UPDATE操作
	 * sql语句
	 * args：填充sql语句的占位符
	 */
	public void update(String sql,Object ... args) {
		Connection connection=null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection,sql,args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
	}
}
