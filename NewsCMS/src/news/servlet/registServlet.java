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

public class registServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String passwd = req.getParameter("password");
		System.out.println("1��");
		String sql = "INSERT INTO users(Uname, Upassword) VALUES('" + username + "','" + passwd + "')";
		req.getSession().setAttribute("userinfo", username);
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		System.out.println("2��");
		if(MysqlDB.executeInsert(stmt, sql)){
			System.out.println("�����ɹ���");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body><h1>ע��ɹ���</h1>");
			String url = "http://localhost:8080/cugNews/";
			out.print("<a href='" + url + "'>�����ת</a></body>");
			out.println("</html>");
		}
		else {
			System.out.println("����ʧ�ܣ�");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body><h1>ע��ʧ�ܣ�</h1>");
			String url = "http://localhost:8080/cugNews/";
			out.print("<a href='" + url + "'>�����ת</a></body>");
			out.println("</html>");
		}
	}

// @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
 doGet(req, resp);
 }
 }
