package DBSetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.log4j.Logger;

public class dbConnection {
	
	public Connection getConn(){
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			//String url = "jdbc:mysql://cugwangping.cn:3306/ThreeLayerDemo_db";
			String url = "jdbc:mysql://localhost:3306/ThreeLayerDemo_db";
			conn = DriverManager.getConnection(url, "root", "231693");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			stmt.execute(insertSql);
			return true;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
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
