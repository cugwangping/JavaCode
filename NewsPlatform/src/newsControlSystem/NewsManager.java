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
 * Servlet implementation class NewsManager
 */
@WebServlet("/NewsManager")
public class NewsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private int newsReleaseTime;
	private String news_Title;
	private String news_Content;
	private String news_Image_Path;
	private NewsType.newsType news_Type;
	
	public NewsManager() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	public NewsManager(int newsID, String newsTitle, NewsType.newsType newsType, 
			String newsContent, String newsImagePath) {
		// TODO Auto-generated constructor stub
		this.news_ID = newsID;
		this.news_Title = newsTitle;
		this.news_Type = newsType;
		this.news_Content = newsContent;
		this.news_Image_Path = newsImagePath;
	}
	
	public NewsType.newsType getNewsType(){
		return this.news_Type;
	}
	
	public boolean addNews() throws SQLException{
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String insertSql = "INSERT INTO news_info(NEWS_ID, NEWS_TITLE, NEWS_TYPE,NEWS_CONTENT, NEWS_IMAGE_PATH)" +  
                 " VALUES ('" + news_ID + "','" + news_Title +"','" + news_Type + "','" + news_Content + "','" + 
				news_Image_Path + "');";  // 插入新闻数据的sql语句  
		if(MysqlDB.executeInsert(stmt, insertSql)){
			System.out.println("发布成功！");
			return true;
		}
		else {
			System.out.println("发布失败！");
			return false;
		}
	}
	
	public ResultSet queryNews(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String querySql = "select * from news_info where news_info.NEWS_ID = " + news_ID + ";";  // 插入新闻数据的sql语句  
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		return rs;
	}
	
	public int updateNews(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String updateSql = "update news_info set NEWS_TITLE = " + news_Title + ", NEWS_TYPE = " + news_Type + 
				", NEWS_CONTENT = " + news_Content + ", NEWS_IMAGE_PATH = " + news_Image_Path + 
				"where news_info.NEWS_ID = " + news_ID + ";";  // 插入新闻数据的sql语句  
		int rs = MysqlDB.executeUpdate(stmt, updateSql);
		return rs;
	}
	
	public void deleteNews(){
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		String deleteSql = "delete from news_info where news_info.NEWS_ID = " + news_ID + ";";  // 插入新闻数据的sql语句  
		MysqlDB.executeDelete(stmt, deleteSql);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
