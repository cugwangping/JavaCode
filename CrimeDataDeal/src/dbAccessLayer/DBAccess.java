package dbAccessLayer;

import java.sql.Connection;
import java.sql.Statement;

import dbSetting.DBConnection;

public class DBAccess {
	private DBConnection dbConn;
	
	//Constructor UserDAO
	public DBAccess(){
		dbConn = new DBConnection();
	}
	
	//插入犯罪事件信息
	public boolean insertInfo(String insertSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeInsertQuery(stmt, insertSql))
			return true;
		else {
			System.out.println("Data access failure");
			return false;
		}
	}
	
	/**
	 // <method>
    // Get User Email By Firstname or Lastname and return DataTable
	//根据用户名查询个人信息
	public ResultSet searchByName(String _userName){
		String queryStr = "SELECT * FROM NIJ2016_JAN01_JUL31 WHERE firstname = '" + _userName + 
				"' OR lastname = '" + _userName + "';";
		System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		return rs;
	}
	//根据ID更新个人信息
	public boolean updateInfo(String updateSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeUpdateQuery(stmt, updateSql))
			return true;
		else {
			return false;
		}
	}
	*/
	
}

