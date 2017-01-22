package cugNews.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cugNews.db.MysqlDB;

public class loginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mUserName = req.getParameter("username");
		String mPassWord = req.getParameter("password");
		//resp.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = resp.getWriter();
		//out.println("<html>");
		//out.println("<body><h1>success!</h1></body>");
		//out.println("</html>");
		String sql = "select * from ;"; //where USER_NAME = '" + mUserName + "';";
		MysqlDB db = new MysqlDB();
		Connection conn = db.getConn();
		Statement stmt = db.getStmt(conn);
		ResultSet rs = db.executeQuery(conn, stmt, sql);
		String passwd = null;
		try {
			passwd = rs.getString("Upassword");
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			//System.out.println("²éÑ¯³ö´í");
		}
		//response.getWriter().append(passwd);
		db.close(rs);
		System.out.println(rs);
		if(passwd == mPassWord)
			resp.getWriter().append("µÇÂ¼³É¹¦");
			//Ìø×ªÒ³Ãæ
			//response.sendRedirect("WebContent/loginSuccess.html");
		else {
			//response.sendRedirect("WebContent/loginFailed.html");
			resp.getWriter().append("µÇÂ¼Ê§°Ü");
			resp.getWriter().append(mUserName);
			resp.getWriter().append(mPassWord);
			resp.getWriter().append(passwd);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
