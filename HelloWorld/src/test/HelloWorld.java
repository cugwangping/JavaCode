package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorld {

	public static void executeSprocInParams(Connection con) {
		   try {
			  //int res = 0;
			  String type = "trad_cook";
			  int year = 1991;
			  String Sql = "{call dbo.p_Count(?,?,?)}";
			  CallableStatement cstmt = con.prepareCall(Sql);
		      //PreparedStatement pstmt = con.prepareStatement(Sql);
		      //pstmt.setInt(1, 50);
			  cstmt.setString(1, type);
			  cstmt.setInt(2, year);
			  
			  cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
			  ResultSet rs = cstmt.executeQuery();
			  //cstmt.execute();
			  while(rs.next()) {
				  System.out.println("pub_id: " + rs.getInt(1));
				}
		      System.out.println("total: " + cstmt.getInt(3));
		      rs.close();
		      cstmt.close();
		      con.close();
		   }
		   catch (Exception e) {
		      e.printStackTrace();
		   }
	}	
	
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pubs";
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(url, "sa", "2316#93");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executeSprocInParams(conn);
	}
}

