package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBSetting.dbConnection;

public class UserDAO {
	private dbConnection dbConn;
	
	//Constructor UserDAO
	public UserDAO(){
		dbConn = new dbConnection();
	}
	
	 // <method>
    // Get User Email By Firstname or Lastname and return DataTable
	//根据用户名查询个人信息
	public ResultSet searchByName(String _userName){
		String queryStr = "SELECT * FROM teac WHERE firstname = '" + _userName + 
				"' OR lastname = '" + _userName + "';";
		System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		return rs;
	}
	
	// <method>
    // Get User Email By Id and return DataTable
	//根据ID查询个人信息
	public ResultSet searchById(String _id){
		String queryStr = "SELECT * FROM teac WHERE idUser = " + _id + ";";
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		return rs;
	}
	
	//Union search by id
	//根据ID查询多人信息
	public ResultSet unionSearchById(String _id1, String _id2){
		String queryStr = "SELECT * FROM teac WHERE idUser BETWEEN "
				+ _id1 + " AND " + _id2 +";";
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		return rs;
	}
	
	//插入个人信息
	public boolean insertInfo(String insertSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeInsertQuery(stmt, insertSql))
			return true;
		else {
			return false;
		}
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
	
}
