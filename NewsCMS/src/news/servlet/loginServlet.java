package news.servlet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.jasper.tagplugins.jstl.core.Out;

import news.dbSetting.MysqlDB;

public class loginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String passwd = req.getParameter("password");
		String sql = "select Upassword from users where Uname='"+username+"' ";
		req.getSession().setAttribute("userinfo", username);
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		ResultSet rs = MysqlDB.executeQuery(stmt, sql);
		String passwd_db = null;
		try {
		if(rs.next()) {
				passwd_db = rs.getString("Upassword");
				if (passwd.equals(passwd_db)) {
					resp.setContentType("text/html;charset=UTF-8");
					PrintWriter out = resp.getWriter();
					out.println("<html>");
					out.println("<body><h1>��½�ɹ���</h1>");
					String url="http://localhost:8080/cugNews/";
					out.print("<a href='"+url+"'>�����ת</a></body>");
					out.println("</html>");
				}
				else{
					resp.setContentType("text/html;charset=UTF-8");
					PrintWriter out = resp.getWriter();
					out.println("<html>");
					out.println("<body><h1>�������</h1></body>");
					out.println("</html>");
				}

			}
			else {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body><h1>���˻�δע�ᣡ</h1>");
				
				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
