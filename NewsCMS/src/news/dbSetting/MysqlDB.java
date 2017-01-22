package news.dbSetting;

import java.sql.*;

public class MysqlDB {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://qdm13875073.my3w.com:3306/qdm13875073_db", "qdm13875073",
					"xs580231");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Statement getStmt(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return stmt;
	}

	public static ResultSet executeQuery(Statement stmt, String querySql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(querySql);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			// System.out.println("Error");
		}
		return rs;
	}

	public static boolean executeInsert(Statement stmt, String insertSql) {
		try {
			if (stmt.execute(insertSql))
				return true;
			else
				return false;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			return false;
		}
	}

	public static int executeUpdate(Statement stmt, String sql) {
		int rs = 0;
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return rs;
	}

	public static boolean executeDelete(Statement stmt, String deleteSql) {
		// stmt.executeDelete(deleteSql);
		try {
			if (stmt.execute(deleteSql))
				return true;
			else {
				return false;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			return false;
		}
	}

	// �ر����ݿ⣬�Ͽ�����
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			rs = null;
		}
	}
}
