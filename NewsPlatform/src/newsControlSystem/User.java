package newsControlSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User {   
	String userName, userPassword; 
	int userID, newsID; 
	//char mUser_Sex;
	//Date mLast_Login, mLast_Logout;
	//int mPressRelease_Number;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //USER_ID, USER_NAME, USER_PASSWORD,USER_EMAIL, USER_STATUS," +
	 //"USER_LEVEL, USER_SEX, LAST_LOGIN, LAST_LOGOUT, PRESS_RELEASE_NUMBER
    public User(String userName, String userPassword, int userID, int newsID) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userID = newsID;
		this.newsID = newsID;
	}
	
	public boolean addUser(Statement stmt) {
		String insertSql = "INSERT INTO users(Uname, Upassword, UID, NewsID)" +  
                 " VALUES ('" + userName + "','" + userPassword + "','" + userID
                 + "','" + newsID + "');";  // 插入新闻数据的sql语句  
		if(MysqlDB.executeInsert(stmt, insertSql)){
			//System.out.println("新增用户成功！");
			return true;
		}
		else {
			//System.out.println("新增用户失败！");
			return false;
		}
	}
	
	public ResultSet queryUser(Statement stmt){
		String querySql = "select * from user where user.UID = " + userID + ";";  
		// 查询用户数据的sql语句  
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		return rs;
	}
	
	public int updateUser(Statement stmt){
		String updateSql = "update user set Uname = " + userName + 
				", Upassword = " + userPassword + ", NewsID = " + newsID 
				+ "where user.UID = " + userID + ";";  // 插入用户数据的sql语句  
		int rs = MysqlDB.executeUpdate(stmt, updateSql);
		return rs;
	}
	
	public void deleteUser(Statement stmt){
		String deleteSql = "delete from user where user.UID = " + userID + ";";  // 删除用户数据的sql语句  
		MysqlDB.executeDelete(stmt, deleteSql);
	}
}

