package bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	@SuppressWarnings("null")
	public static boolean connect(String userName){
		String driver = "oracle.jdbc.driver.OracleDriver";  
	     String strUrl = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";  
	     Statement stmt = null;  
	     ResultSet rs = null;  
	     Connection conn = null; 
	     try {
			Class.forName(driver);
			conn =   DriverManager.getConnection(strUrl, "scott", "feng2316"); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     String sql = "SELECT MIMA FROM CAOZUOYUANXINXIBIAO WHERE YONGHUMING=" + userName +";";//查询密码是否存在
	     try {
			rs = stmt.executeQuery(sql);
			if(rs.next()){
		         // 当结果集不为空时
		         return true;
		     }
		     else {
		    	 return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
