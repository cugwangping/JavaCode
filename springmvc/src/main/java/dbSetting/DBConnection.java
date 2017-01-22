package dbSetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.log4j.Logger;

public class DBConnection {
	
	public Connection getConn(){
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://cugwangping.cn:3306/crime_event";
			conn = DriverManager.getConnection(url, "root", "231693");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Database connection is successful");
		return conn;
	}
	
	public Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//查找操作
	public ResultSet executeSelectQuery(Statement stmt, String selectSql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(selectSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//插入操作
	public boolean executeInsertQuery(Statement stmt, String insertSql) {
		try {
			//stmt.executeUpdate(insertSql);
			stmt.execute(insertSql);
			System.out.println("插入执行成功");
			return true;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			System.out.println("数据异常");
			return false;
		}
	}
	
	//更新操作
	public boolean executeUpdateQuery(Statement stmt, String updateSql) {
		try {
			stmt.execute(updateSql);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	//删除操作
	public boolean executeDeleteQuery(Statement stmt, String deleteSql){
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
	public void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}

