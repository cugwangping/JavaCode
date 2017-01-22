package test;

import java.sql.*;

public class OrclProcTest {
	public static void main(String args[]) throws Exception 
	{ 
	   //加载Oracle驱动 
	   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 
	   //获得Oracle数据库连接 
	   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","feng2316"); 

	    //创建Oracle存储过程的对象，调用存储过程 
	    CallableStatement c=conn.prepareCall("{call pro2(?)}"); 
	     
	    //给Oracle存储过程的参数设置值 ，将第一个参数的值设置成188 
	    c.setInt(1,188); 
	    //注册存储过程的第二个参数 
	      c.registerOutParameter(2,java.sql.Types.INTEGER);    //执行Oracle存储过程 
	    c.execute(); 
	      //得到存储过程的输出参数值并打印出来
	      System.out.println (c.getInt(2)); 
	    conn.close(); 
	} 

}