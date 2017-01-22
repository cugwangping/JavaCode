package testNewSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cownew.cownewsql.imsql.ISQLTranslator;
//import com.cownew.cownewsql.imsql.common.DataBaseTypeEnum;
import com.cownew.cownewsql.imsql.common.DialectManager;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class MainTest
{
  public static void main(String[] args) throws TranslateException
  {
    ISQLTranslator tx = DialectManager.createTranslator("MYSQL");
    String[] venderSQLs;
    String font_sql= "select top 5 * from teac;";
    System.out.println("翻译前的SQL:	" + font_sql);
    venderSQLs = tx.translateSQL(font_sql);
    String back_sql=venderSQLs[0];
    System.out.println("翻译后的SQL:	" + back_sql);
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
	try {
		//String driver = "com.mysql.jdbc.Driver";	//Mysql JDBC Driver
		String driver="com.cownew.cownewsql.imsql.jdbc.DBDriver";	//CowNewSQL Driver
		Class.forName(driver);
		//String url = "jdbc:mysql://localhost:3306/ThreeLayerDemo_db";	//Mysql JDBC connection string
		String url="jdbc:cownewsql:mysql:com.mysql.jdbc.Driver:jdbc:mysql://localhost:3306/ThreeLayerDemo_db";
		//CowNewSQL connection string
		conn = DriverManager.getConnection(url, "root", "231693");	
		stmt = (Statement) conn.createStatement();
		//查找
		rs=stmt.executeQuery(font_sql);
		System.out.println("firstname	idUser	lastname	email");
		while(rs.next()){
			System.out.println(rs.getString(1)+"	"+ rs.getInt(2)+"	"
					+ rs.getString(3)+"		" + rs.getString(4));
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
}
