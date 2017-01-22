package BUS;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UserDAO;
import VO.UserVO;

public class UserBUS {
	private UserDAO _userDAO;
	
	//<constructor>
	//Constructor UserBUS
	public UserBUS(){
		_userDAO = new UserDAO();
	}
	
	 /// <method>
    /// Get User Email By Firstname or Lastname and return VO
    /// </method>
	//根据用户名来查询个人信息
    public UserVO getUserByName(String name)
    {
        UserVO userVO = new UserVO();
        ResultSet rs =_userDAO.searchByName(name);

        try {
			while(rs.next())
			{
			    userVO.setFirstName(rs.getString(1));
			    userVO.setIdUser(rs.getInt(2));
			    userVO.setLastName(rs.getString(3));
			    userVO.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return userVO;
    }
    
    //根据ID号来查询个人信息
    public UserVO getUserById(String id)
    {
        UserVO userVO = new UserVO();
        ResultSet rs =_userDAO.searchById(id);

        try {
			while(rs.next())
			{
			    userVO.setFirstName(rs.getString(1));
			    userVO.setIdUser(rs.getInt(2));
			    userVO.setLastName(rs.getString(3));
			    userVO.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return userVO;
    }
    
  //根据ID号来查询多人信息
	public String[] getUserById(String id1, String id2)		
    {
        ResultSet rs =_userDAO.unionSearchById(id1, id2);
        int i = 0;
        String s = "";
        try {
			while(rs.next())
			{
				i++;
				s += "第" + i + "条记录：," + "firstname: " + rs.getString(1) + ",idUser: " + 
						rs.getInt(2) + ",lastname: " + rs.getString(3) + 
						",email: " + rs.getString(4) + ",";		//,代表分割符
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String result = "查询到的总记录数为： " + i + ",查询信息为：," + s;		//查询到的结果，","代表换行符
        String[] contents = result.split(",");		//需要显示的列表内容
        return contents;
    }
	
	//插入个人信息
	public boolean InfoInput(UserVO _userVO){
		 String insertSql = "insert into teac values('" + _userVO.getFirstName() +
				 "', " + _userVO.getIdUser() + ", '" + _userVO.getLastName() + 
				 "', '" + _userVO.getEmail() + "');";
		 if(_userDAO.insertInfo(insertSql))
			 return true;
		 else {
			return false;
		}
	}
	
	//根据ID更新个人信息
	public boolean InfoUpdate(UserVO _userVO){
		 String updateSql = "update teac set firstname = '" + _userVO.getFirstName() +
				 "', lastname = '" + _userVO.getLastName() + 
				 "', email = '" + _userVO.getEmail() + "' where idUser = " + 
				 _userVO.getIdUser() + ";";
		 if(_userDAO.updateInfo(updateSql))
			 return true;
		 else {
			return false;
		}
	}
}
