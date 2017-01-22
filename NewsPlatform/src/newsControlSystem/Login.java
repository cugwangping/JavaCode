package newsControlSystem;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    	super();
    }
    
    @Override
    public void init() throws ServletException{
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("doGet.......");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mUserName = request.getParameter("username");
		String mPassWord = request.getParameter("password");
		String sql = "select USER_PASSWORD from user_info;"; //where USER_NAME = '" + mUserName + "';";
		MysqlDB db = new MysqlDB();
		Connection conn = db.getConn();
		Statement stmt = db.getStmt(conn);
		ResultSet rs = db.executeQuery(stmt, sql);
		String passwd = null;
		try {
			passwd = rs.getString("USER_PASSWORD");
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			//System.out.println("查询出错");
		}
		//response.getWriter().append(passwd);
		db.close(rs);
		System.out.println(rs);
		if(passwd == mPassWord)
			response.getWriter().append("登录成功");
			//跳转页面
			//response.sendRedirect("WebContent/loginSuccess.html");
		else 
			//response.sendRedirect("WebContent/loginFailed.html");
		response.getWriter().append(mUserName);
		response.getWriter().append(mPassWord);
		response.getWriter().append(passwd);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
