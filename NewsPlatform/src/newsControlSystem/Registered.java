package newsControlSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registered
 */
public class Registered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registered() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */

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
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String mUserID = request.getParameter("UID");		//用户身份的唯一标识
		String querySql = "select * from user_info where USER_ID = " + mUserID;
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		try {
			if(rs.next()){
				response.getWriter().append("此帐号已经被占用！");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mUserName = request.getParameter("username");
		String mPassWord = request.getParameter("password");
		String mRePassWord = request.getParameter("rePassword");
		
		if(mPassWord != mRePassWord){
			response.getWriter().append("两次密码输入不匹配！");
			return;
		}
		//String mEmail = request.getParameter("email");
		int userID = Integer.parseInt(mUserID);
		User newUser = new User(mUserName, mPassWord, userID, 0);
		if(newUser.addUser(stmt)){
			response.getWriter().append("注册成功！即将返回登录界面");
			response.sendRedirect("../../WebContent/login.jsp");  
			//重定向到一个jsp页面

		}
		else {
			response.getWriter().append("注册失败!");
			response.sendRedirect("../../WebContent/registeredFailed");
		}
	}	
}
