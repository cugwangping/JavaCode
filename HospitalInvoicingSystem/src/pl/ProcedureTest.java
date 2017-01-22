package pl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ProcedureTest {
	//连接oracle数据库
	public Connection connect(){  
	     String driver = "oracle.jdbc.driver.OracleDriver";  
	     String strUrl = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";  
	     Statement stmt = null;  
	     ResultSet rs = null;  
	     Connection conn = null;  
	     try {  
	       Class.forName(driver);  
	       conn =   DriverManager.getConnection(strUrl, "scott", "feng2316");  
	     } 
	     catch (Exception ex2) {  
	       ex2.printStackTrace();  
	     }  
	     finally{  
	       try {  
	         if(rs != null){  
	           rs.close();  
	           if(stmt!=null){  
	             stmt.close();  
	           }  
	           if(conn!=null){  
	             conn.close();  
	           }  
	         }  
	       }  
	       catch (SQLException ex1) {  
	       }  
	     }  
	     return conn;
	  } 
	//调用存储过程
	public void YAOPIN_PRO(Connection conn,String YAOPIN_MINGCHENG){
		   CallableStatement proc = null;  
		   try {
			proc = conn.prepareCall("{ call YAOPIN_PRO(?,?,?,?,?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       //String YAOPIN_MINGCHENG="希美纳";
	       try {
			proc.setString(1, YAOPIN_MINGCHENG);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //设置输入参数
	       String YAOPIN_BIANHAO = null;  
		   String YAOPIN_DANWEI = null; 
		   String YAOPIN_YAOXIAOQI = null; 
		   float YAOPIN_LINGSHOUJIAGE = 0;
	       try {
	    	 //注册输出参数  
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
		    proc.registerOutParameter(4, Types.VARCHAR);
		    proc.registerOutParameter(5, Types.FLOAT);
		    proc.execute(); 
		    YAOPIN_BIANHAO = proc.getString(2);  
		    YAOPIN_DANWEI = proc.getString(3); 
		    YAOPIN_YAOXIAOQI = proc.getString(4); 
		    YAOPIN_LINGSHOUJIAGE = proc.getFloat(5); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       System.out.println("药品编号："+YAOPIN_BIANHAO);
	       System.out.println("药品单位："+YAOPIN_DANWEI);
	       System.out.println("药品有效期："+YAOPIN_YAOXIAOQI);
	       System.out.println("药品零售价格："+YAOPIN_LINGSHOUJIAGE); 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcedureTest test=new ProcedureTest();
		Connection conn=test.connect();
		String YAOPIN_MINGCHENG="希美纳";
		test.YAOPIN_PRO(conn, YAOPIN_MINGCHENG);
	}

}
