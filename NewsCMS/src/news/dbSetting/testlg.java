package news.dbSetting;
import java.sql.*;

public class testlg {
	public static void main(String[] args) throws SQLException {
		String sql = "select * from users";
		Connection conn = MysqlDB.getConn();
		Statement stmt = MysqlDB.getStmt(conn);
		ResultSet rs = MysqlDB.executeQuery(stmt, sql);
		String username=null;
		String passwd = null;
		while(rs.next()){
			username=rs.getString("Uname");
			if(username.equals("luckysonge"))
			{
				try {
					passwd = rs.getString("Upassword");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("��ѯ����");
				}
			}
		}
		//response.getWriter().append(passwd);		
		if(passwd.equals("xs580231")){
			System.out.println("��¼�ɹ�");
		}
		//System.out.print(mUserName);
		//System.out.print(mPassWord);
		//response.getWriter().append(mUserName);
		//response.getWriter().append(mPassWord);
		}

}
