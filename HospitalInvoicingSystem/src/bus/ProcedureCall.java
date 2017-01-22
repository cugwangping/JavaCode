package bus;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ProcedureCall {

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
	 
	 //1.药品采购订单查询
	 public String YAOPINRUKU_PRO(Connection conn){
		 CallableStatement proc = null;  
	       try {
			proc = conn.prepareCall("{ call YAOPINRUKU_PRO(?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       try {
			proc.registerOutParameter(1, Types.INTEGER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//注册输出参数  
	       try {
			proc.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       Integer orderNum=null;
		try {
			orderNum = proc.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       return orderNum.toString();   
	 }
	 
	 //2.药品基本信息查询
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
	 
	//3.客户基本信息查询
	 public void KEHU_PRO(Connection conn,String KEHU_MINGCHENG){
		   CallableStatement proc = null;  
		   try {
			proc = conn.prepareCall("{ call KEHU_PRO(?,?,?,?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //设置输入参数
	       //String KEHU_MINGCHENG="卢中财";
	       try {
			proc.setString(1, KEHU_MINGCHENG);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       String KEHU_BIANHAO = null;  
		   String KEHU_DIDIZHI = null; 
		   String KEHU_LIANXIDIANHUA = null; 
	       try {
	    	 //注册输出参数  
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
		    proc.registerOutParameter(4, Types.VARCHAR);
		    proc.execute(); 
		    KEHU_BIANHAO = proc.getString(2);  
		    KEHU_DIDIZHI = proc.getString(3); 
		    KEHU_LIANXIDIANHUA = proc.getString(4); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       System.out.println("客户编号："+KEHU_BIANHAO);
	       System.out.println("客户地址："+KEHU_DIDIZHI);
	       System.out.println("客户联系电话："+KEHU_LIANXIDIANHUA);
	 }
	 
	//4.药品库存盘点信息查询
	 public void YAOPINKUCUNPANDIAN_PRO(Connection conn,Date YAOPIN_PANDIANRIQI){
		   CallableStatement proc = null;  
		   try {
			proc = conn.prepareCall("{ call YAOPINKUCUNPANDIAN_PRO(?,?,?,?,?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //设置输入参数
	       //Date YAOPIN_PANDIANRIQI=new Date(2007, 12, 1);
	       try {
			proc.setDate(1, YAOPIN_PANDIANRIQI);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       String YAOPIN_BIANHAO = null;  
		   Integer YAOPIN_RUKUSHULIANG = null; 
		   Integer YAOPIN_XIAOSHOUSHULIANG = null; 
		   Integer YAOPIN_KUCUNSHULIANG = null;
	       try {
	    	 //注册输出参数  
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.INTEGER);
		    proc.registerOutParameter(4, Types.INTEGER);
		    proc.registerOutParameter(5, Types.INTEGER);
		    proc.execute(); 
		    YAOPIN_BIANHAO = proc.getString(2);  
		    YAOPIN_RUKUSHULIANG = proc.getInt(3); 
		    YAOPIN_XIAOSHOUSHULIANG = proc.getInt(4); 
		    YAOPIN_KUCUNSHULIANG = proc.getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       System.out.println("药品编号："+YAOPIN_BIANHAO);
	       System.out.println("药品入库数量："+YAOPIN_RUKUSHULIANG);
	       System.out.println("药品销售数量："+YAOPIN_XIAOSHOUSHULIANG);
	       System.out.println("药品库存数量："+YAOPIN_KUCUNSHULIANG);
	 }
	 
	//5.操作员基本信息查询
	 public void CAOZUOYUAN_PRO(Connection conn,String YONGHU_MINGCHENG){
		   CallableStatement proc = null;  
		   try {
			proc = conn.prepareCall("{ call CAOZUOYUAN_PRO(?,?,?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       //String YONGHU_MINGCHENG="李昌盛";
	       try {
			proc.setString(1, YONGHU_MINGCHENG);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //设置输入参数
	       String YONGHU_BIANHAO = null;  
		   String YONGHU_QUANXIAN = null; 
	       try {
	    	 //注册输出参数  
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
		    proc.execute(); 
		    YONGHU_BIANHAO = proc.getString(2);  
		    YONGHU_QUANXIAN = proc.getString(3); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       System.out.println("药品编号："+YONGHU_BIANHAO);
	       System.out.println("药品单位："+YONGHU_QUANXIAN);
	 }
	 
	//6.药品销售信息查询
	 public void YAOPINXIAOSHOU_PRO(Connection conn,String YAOPIN_XIAOSHOULIUSHUIHAO){
		   CallableStatement proc = null;  
		   try {
			proc = conn.prepareCall("{ call YAOPINXIAOSHOU_PRO(?,?,?,?,?,?,?) }");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //设置输入参数
	       //String YAOPIN_XIAOSHOULIUSHUIHAO=null;
	       try {
			proc.setString(1, YAOPIN_XIAOSHOULIUSHUIHAO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       String YAOPIN_BIANHAO = null;  
		   String YAOPIN_XIAOSHOUDANJUHAO = null; 
		   Integer YAOPIN_XIAOSHOUSHULIANG = null; 
		   float YAOPIN_XIAOSHOUDANJIA = 0;
		   float YAOPIN_XIAOSHOUJINE = 0;
		   Date YAOPIN_XIAOSHOURIQI = null;
	       try {
	    	 //注册输出参数  
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
		    proc.registerOutParameter(4, Types.INTEGER);
		    proc.registerOutParameter(5, Types.FLOAT);
		    proc.registerOutParameter(6, Types.FLOAT);
		    proc.registerOutParameter(6, Types.DATE);
		    proc.execute(); 
		    YAOPIN_BIANHAO = proc.getString(2);  
		    YAOPIN_XIAOSHOUDANJUHAO = proc.getString(3); 
		    YAOPIN_XIAOSHOUSHULIANG = proc.getInt(4); 
		    YAOPIN_XIAOSHOUDANJIA = proc.getFloat(5);
		    YAOPIN_XIAOSHOUJINE = proc.getFloat(6);
		    YAOPIN_XIAOSHOURIQI = proc.getDate(7);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       System.out.println("药品编号："+YAOPIN_BIANHAO);
	       System.out.println("药品入库数量："+YAOPIN_XIAOSHOUDANJUHAO);
	       System.out.println("药品销售数量："+YAOPIN_XIAOSHOUSHULIANG);
	       System.out.println("药品库存数量："+YAOPIN_XIAOSHOUDANJIA);
	       System.out.println("药品库存数量："+YAOPIN_XIAOSHOUJINE);
	       System.out.println("药品库存数量："+YAOPIN_XIAOSHOURIQI);
	 }
}
