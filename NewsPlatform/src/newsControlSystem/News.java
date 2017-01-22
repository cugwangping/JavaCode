package newsControlSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class News {
	private Date newsReleaseTime;
	private int releaseUserID;
	private String newsContent;
	private String newsName;
	private int newsID;
	private NewsType.newsType newsType;
	
	public News() {
	        super();
	    }
	
	//文章的属性，newsID为文章表的主键
	public News(Date newsReleaseTime, int releaseUserID, String newsContent, 
			String newsName, int newsID, NewsType.newsType newsType) {
		this.newsReleaseTime = newsReleaseTime;
		this.releaseUserID = releaseUserID;
		this.newsContent = newsContent;
		this.newsName = newsName;
		this.newsID = newsID;
		this.newsType = newsType;
	}
	
	public boolean addNews(Statement stmt) throws SQLException{
		String insertSql = "INSERT INTO article(time, UID, Article_content,"
				+ " Article_name, Article_ID, Article_kind)" +  " VALUES ('"
				+ newsReleaseTime + "','" + releaseUserID + "','" + newsContent
				+ "','" + newsName + "','" + newsID + "','" + newsType + "');";
				// 插入新闻数据的sql语句  
		if(MysqlDB.executeInsert(stmt, insertSql)){
			//System.out.println("发布成功！");
			return true;
		}
		else {
			//System.out.println("发布失败！");
			return false;
		}
	}
	
	public ResultSet queryNews(Statement stmt){
		String querySql = "select * from article where article.Article_ID = "
				+ newsID + ";";  // 插入新闻数据的sql语句  
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		return rs;
	}
	
	public int updateNews(Statement stmt){
		String updateSql = "update article set time = " + newsReleaseTime +
				", UID = " + releaseUserID + ", Article_content = " + newsContent 
				+ ", Article_name = " + newsName + "where article.Article_ID = "
				+ newsID + ";";  // 插入新闻数据的sql语句  
		int rs = MysqlDB.executeUpdate(stmt, updateSql);
		return rs;
	}
	
	public void deleteNews(Statement stmt){
		String deleteSql = "delete from article where article.Article_ID = " 
				+ newsID + ";";  // 插入新闻数据的sql语句  
		MysqlDB.executeDelete(stmt, deleteSql);
	}
}
