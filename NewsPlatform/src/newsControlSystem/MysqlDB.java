package newsControlSystem;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDB {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsplatform?autoReconnect=true&useSSL=false", "root", "231693");
		} catch (ClassNotFoundException ce) {
			// TODO Auto-generated catch block
			ce.printStackTrace();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return conn;
	}
	
	public static Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return stmt;
	}
	
	public static ResultSet executeQuery(Statement stmt, String querySql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(querySql);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			//System.out.println("Error");
		}
		return rs;
	}
	
	public static boolean executeInsert(Statement stmt, String insertSql) {
		try {
			if(stmt.execute(insertSql))
				return true;
			else 
				return false;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			return false;
		}
	}
	
	public static int executeUpdate(Statement stmt, String sql) {
		int rs = 0;
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return rs;
	}
	
	public static boolean executeDelete(Statement stmt, String deleteSql){
		//stmt.executeDelete(deleteSql);
		try {
			if(stmt.execute(deleteSql))
				return true;
			else {
				return false;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			return false;
		}
	}
	
	//关闭数据库，断开连接
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			rs = null;
		}
	}
}
