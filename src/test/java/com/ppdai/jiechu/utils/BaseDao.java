package com.ppdai.jiechu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDao<T> {
    public static final String sqlServerClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String mysqlClassName="com.mysql.jdbc.Driver";
    public static final String sqlServer1Url="jdbc:sqlserver://172.17.0.19:2433;DatabaseName=ppdai";
    public static final String sqlServer1User="test_new";
    public static final String sqlServer1Pwd="ppdtest@tGzu590z";
    public static final String sqlServer2Url="jdbc:sqlserver://172.17.0.20:2433;DatabaseName=ppdai";
    public static final String sqlServer2User="test_new";
    public static final String sqlServer2Pwd="ppdtest@tGzu590z";
    public static final String mysql1Url="jdbc:mysql://172.17.0.12:3403/test?useUnicode=true&characterEncoding=utf-8&useSSL=true";
    public static final String mysql1User="user_app_pfq_trans";
    public static final String mysql1Pwd="ppdtest@tGzu590z";
    public static final String mysql2Url="jdbc:mysql://192.168.212.172:3406/test?;useUnicode=true&characterEncoding=utf-8&useSSL=true";
    public static final String mysql2User="root";
    public static final String mysql2Pwd="123456";
	private String className;
	private String url;
	private String user;
	private String pwd;

    public BaseDao(String className, String url, String user, String pwd) {
        this.className=className;
        this.url=url;
        this.user=user;
        this.pwd=pwd;
    	DbUtils.loadDriver(this.className);
    }
    
    public Connection getConn() throws SQLException {
        Connection conn=DriverManager.getConnection(this.url,this.user,this.pwd);
        return conn;
    }
    
    public int insert(String sql) throws SQLException{  
        Connection conn = this.getConn();            
        QueryRunner qRunner = new QueryRunner();
        int n = qRunner.update(conn, sql);   
        DbUtils.closeQuietly(conn);
        return n;
    }
    
    public List<T> select(String sql, Class<T> type) throws SQLException{  
        Connection conn = getConn();
        QueryRunner qRunner = new QueryRunner();
        @SuppressWarnings({ "unchecked", "rawtypes" })
		List<T> list = (List<T>) qRunner.query(conn, sql, new BeanListHandler(type));
        DbUtils.closeQuietly(conn);
        return list;
    }
    
    public int update(String sql) throws SQLException{  
        Connection conn = this.getConn();          
        QueryRunner qRunner = new QueryRunner();   
        int n = qRunner.update(conn, sql);   
        DbUtils.closeQuietly(conn);
        return n;
    }

    public int del(String sql) throws SQLException{  
        Connection conn = this.getConn();          
        QueryRunner qRunner = new QueryRunner();   
        int n = qRunner.update(conn, sql);   
        DbUtils.closeQuietly(conn);
        return n;
    }
}