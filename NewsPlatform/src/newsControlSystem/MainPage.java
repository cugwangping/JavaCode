package newsControlSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
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
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
			//System.out.println("��ѯ����");
		}
		//response.getWriter().append(passwd);
		db.close(rs);
		System.out.println(rs);
		if(passwd == mPassWord)
			response.getWriter().append("��¼�ɹ�");
			//��תҳ��
			//response.sendRedirect("WebContent/loginSuccess.html");
		else 
			//response.sendRedirect("WebContent/loginFailed.html");
		response.getWriter().append(mUserName);
		response.getWriter().append(mPassWord);
		response.getWriter().append(passwd);
	}

}
