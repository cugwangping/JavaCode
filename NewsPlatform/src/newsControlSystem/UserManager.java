package newsControlSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManager
 */
@WebServlet("/UserManager")
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int mUser_ID; 
	String mUser_Name, mUser_Password, mUser_Email; 
	int mUser_Status, mUser_Level; 
	char mUser_Sex;
	Date mLast_Login, mLast_Logout;
	int mPressRelease_Number;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManager() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //USER_ID, USER_NAME, USER_PASSWORD,USER_EMAIL, USER_STATUS," +
	 //"USER_LEVEL, USER_SEX, LAST_LOGIN, LAST_LOGOUT, PRESS_RELEASE_NUMBER
    public UserManager(int UserID, String UserName, String UserPassword, String UserEmail, 
			int UserStatus, int UserLevel, char UserSex, Date LastLogin, Date LastLogout, 
			int PressReleaseNumber) {
		// TODO Auto-generated constructor stub
		this.mUser_ID = UserID;
		this.mUser_Name = UserName;
		this.mUser_Password = UserPassword;
		this.mUser_Email = UserEmail;
		this.mUser_Status = UserStatus;
		this.mUser_Level = UserLevel;
		this.mUser_Sex = UserSex;
		this.mLast_Login = LastLogin;
		this.mLast_Logout = LastLogout;
		this.mPressRelease_Number = PressReleaseNumber;
	}
	
	public boolean addUser() throws SQLException{
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String insertSql = "INSERT INTO user_info(USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_STATUS"
				+ "USER_LEVEL, USER_SEX, LAST_LOGIN, LAST_LOGOUT, PRESS_RELEASE_NUMBER)" +  
                 " VALUES ('" + mUser_ID + "','" + mUser_Name + "','" + mUser_Password + "','" + mUser_Email +
                 "','" + mUser_Status + "','" + mUser_Level + "','" + mUser_Sex + "','" + mLast_Login + "','" +
                 mLast_Logout + mPressRelease_Number + "');";  // 插入新闻数据的sql语句  
		if(MysqlDB.executeInsert(stmt, insertSql)){
			System.out.println("新增用户成功！");
			return true;
		}
		else {
			System.out.println("新增用户失败！");
			return false;
		}
	}
	
	public ResultSet queryUser(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String querySql = "select * from user_info where user_info.USER_ID = " + mUser_ID + ";";  // 查询用户数据的sql语句  
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		return rs;
	}
	
	public int updateUser(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String updateSql = "update user_info set USER_NAME = " + mUser_Name + ", USER_PASSWORD = " + mUser_Password + 
				", USER_EMAIL = " + mUser_Email + ", USER_STATUS = " + mUser_Status + ", USER_LEVEL = " + mUser_Level + 
				", USER_SEX = " + mUser_Sex + ", LAST_LOGIN = " + mLast_Login + ", LAST_LOGOUT = " + mLast_Logout + 
				", PRESS_RELEASE_NUMBER = " + mPressRelease_Number + "where user_info.USER_ID = " + mUser_ID + ";";  // 插入用户数据的sql语句  
		int rs = MysqlDB.executeUpdate(stmt, updateSql);
		return rs;
	}
	
	public void deleteUser(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String deleteSql = "delete from user_info where user_info.USER_ID = " + mUser_ID + ";";  // 删除用户数据的sql语句  
		MysqlDB.executeDelete(stmt, deleteSql);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String mUserName = request.getParameter("username");
		String mPassWord = request.getParameter("password");
		String sql = "select USER_PASSWORD from user_info where USER_NAME = " + mUserName + ";";
		//MysqlDB db= new MysqlDB();
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		ResultSet rs = MysqlDB.executeQuery(stmt, sql);
		String passwd = null;
		try {
			passwd = rs.getString("USER_PASSWORD");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("查询出错");
		}
		//response.getWriter().append(passwd);
		
		if(passwd == mPassWord)
			//response.getWriter().append("登录成功");
			//跳转页面
			response.sendRedirect("../../WebContent/loginSuccess.html");
		else 
			response.sendRedirect("../../WebContent/loginFailed.html");
	}

}
