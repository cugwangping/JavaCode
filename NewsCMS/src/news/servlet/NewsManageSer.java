package news.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import news.dbSetting.*;

public class NewsManageSer {
	private Date newsReleaseTime;
	private int releaseUserID;
	private String newsContent;
	private String newsName;
	private int newsID;
	private NewsType.newsType newsType;
	
	public NewsManageSer() {
	        super();
	    }
	
	//
	public NewsManageSer(Date newsReleaseTime, int releaseUserID, String newsContent, 
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
				//  
		if(MysqlDB.executeInsert(stmt, insertSql)){
			//System.out.println("");
			return true;
		}
		else {
			//System.out.println("����ʧ�ܣ�");
			return false;
		}
	}
	
	public ResultSet queryNews(Statement stmt){
		String querySql = "select * from article where article.Article_ID = "
				+ newsID + ";";  // �����������ݵ�sql���  
		ResultSet rs = MysqlDB.executeQuery(stmt, querySql);
		return rs;
	}
	
	public int updateNews(Statement stmt){
		String updateSql = "update article set time = " + newsReleaseTime +
				", UID = " + releaseUserID + ", Article_content = " + newsContent 
				+ ", Article_name = " + newsName + "where article.Article_ID = "
				+ newsID + ";";  // �����������ݵ�sql���  
		int rs = MysqlDB.executeUpdate(stmt, updateSql);
		return rs;
	}
	
	public void deleteNews(Statement stmt){
		String deleteSql = "delete from article where article.Article_ID = " 
				+ newsID + ";";  // �����������ݵ�sql���  
		MysqlDB.executeDelete(stmt, deleteSql);
	}
}
