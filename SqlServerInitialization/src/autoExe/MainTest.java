package autoExe;

import java.util.Arrays;  
import java.util.List;

import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class MainTest {

	 /** 
     * 读取 SQL 文件，获取 SQL 语句 
     * @param sqlFile SQL 脚本文件 
     * @return List<sql> 返回所有 SQL 语句的 List 
     * @throws Exception 
     */  
    private List<String> loadSql(String sqlFile) throws Exception {  
        List<String> sqlList = new ArrayList<String>();  
  
        try {  
            InputStream sqlFileIn = new FileInputStream(sqlFile);  
  
            StringBuffer sqlSb = new StringBuffer();  
            byte[] buff = new byte[1024];  
            int byteRead = 0;  
            while ((byteRead = sqlFileIn.read(buff)) != -1) {  
                sqlSb.append(new String(buff, 0, byteRead));  
            }  
  
            String[] sqlArr = sqlSb.toString().split("(;//s*//r//n)|(;//s*//n)");  
            for (int i = 0; i < sqlArr.length; i++) {  
                String sql = sqlArr[i].replaceAll("--.*", "").trim();  
                if (!sql.equals("")) {  
                    sqlList.add(sql);  
                }  
            }  
            return sqlList;  
        } catch (Exception ex) {  
            throw new Exception(ex.getMessage());  
        }  
    }   
  
    /** 
     * 传入连接来执行 SQL 脚本文件，这样可与其外的数据库操作同处一个事物中 
     * @param conn 传入数据库连接 
     * @param sqlFile SQL 脚本文件 
     * @throws Exception 
     */  
    public void execute(Connection conn, String sqlFile) throws Exception {  
        Statement stmt = null;  
        List<String> sqlList = loadSql(sqlFile);  
        stmt = conn.createStatement();  
        for (String sql : sqlList) {  
            stmt.addBatch(sql);  
        }  
        int[] rows = stmt.executeBatch();  
        System.out.println("Row count:" + Arrays.toString(rows));  
    }  
  
    /** 
     * 自建连接，独立事物中执行 SQL 文件 
     * @param sqlFile SQL 脚本文件 
     * @throws Exception 
     */  
    public void execute(String sqlFile) throws Exception {  
        Connection conn = DBconnect.getConn();  
        Statement stmt = null;  
        List<String> sqlList = loadSql(sqlFile);  
        conn.setAutoCommit(false);  
        stmt = conn.createStatement();  
        for (String sql : sqlList) {  
            stmt.addBatch(sql);  
        }  
        int[] rows = stmt.executeBatch();  
        System.out.println("Row count:" + Arrays.toString(rows));    
  
    }  
  
    public static void main(String[] args) throws Exception {  
         MainTest mt= new MainTest();
         JFileChooser fd = new JFileChooser();  
    	 fd.setFileSelectionMode(JFileChooser.OPEN_DIALOG);  
    	 fd.showOpenDialog(null);  
    	 File f = fd.getSelectedFile();  
    	 if(f != null){
    		 System.out.println("加载文件");
    	 }else {
			 System.out.println("文件打开失败");
		 }	
         List<String> sqlList = mt.loadSql(f.toString()); 
        System.out.println("size:" + sqlList.size());  
        for (String sql : sqlList) {  
            System.out.println(sql);  
        }  
    }  

}
