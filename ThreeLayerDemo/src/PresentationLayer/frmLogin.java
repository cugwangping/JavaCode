package PresentationLayer;

import BUS.UserBUS;
import VO.UserVO;
import JList.MyJList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmLogin {
	 private UserBUS _userBUS;
	 
	 //初始化
	 public frmLogin()
     {
         this._userBUS = new UserBUS();
     }
	 
	 public String getInput(Boolean in){
		 String Input = null;
		 if(in)
		 {
			 Input = JOptionPane.showInputDialog(null, "输入新的信息:", "个人信息录入",
					 JOptionPane.PLAIN_MESSAGE);
		 }
		 else {
			 Input = JOptionPane.showInputDialog(null, "输入修改的信息：", "个人信息更新",
					 JOptionPane.PLAIN_MESSAGE);
		}
		 return Input;
	 }
	 
	 //根据用户名查询个人信息
     //@SuppressWarnings("unused")
	public void SearchUserByName(String _name)
     {
         UserVO _userVO = new UserVO();
         _userVO = _userBUS.getUserByName(_name);
         String result = "firstname: " + _userVO.getFirstName()+ "\nidUser: "
        		 + _userVO.getIdUser() + "\nlastname: " +
        		 _userVO.getLastName() + "\nemail: " + _userVO.getEmail();
         if (result == ""){
             //JOptionPane.showMessageDialog(null,"No Match Found!");
        	 JOptionPane.showMessageDialog(null, "NULL", "查询结果",
        			 JOptionPane.WARNING_MESSAGE);  
         }
         else{
        	 //JOptionPane.showMessageDialog(null,_email);  
        	 JOptionPane.showMessageDialog(null, result, "查询结果",JOptionPane.PLAIN_MESSAGE);  
         }
     }
     
     //根据ID查询个人信息
     public void SearchUserById(String _id){
    	 UserVO _userVO = new UserVO();
    	 _userVO = _userBUS.getUserById(_id);
    	 String result = "firstname: " + _userVO.getFirstName()+ "\nidUser: "
        		 + _userVO.getIdUser() + "\nlastname: " +
        		 _userVO.getLastName() + "\nemail: " + _userVO.getEmail();
         if (result == ""){
             //JOptionPane.showMessageDialog(null,"No Match Found!");
        	 JOptionPane.showMessageDialog(null, "NULL", "查询结果",JOptionPane.WARNING_MESSAGE);  
         }
         else{
        	 //JOptionPane.showMessageDialog(null,_email);  
        	 JOptionPane.showMessageDialog(null, result, "查询结果",JOptionPane.PLAIN_MESSAGE);  
         }
     }
     
     //根据ID查询多人信息
	public void UnionSearchUserById(String _id1, String _id2){
    	String[] contents = _userBUS.getUserById(_id1, _id2);
        //JOptionPane.showMessageDialog(null, result, "查询结果",JOptionPane.PLAIN_MESSAGE);  
        new MyJList(contents);
     }
     
     public void DoMethod(){
    	 Object[] options ={ "用户名查询", "ID查询", "信息录入", "信息更新" }; 
    	 /*int n = JOptionPane.showOptionDialog(null, "信息查询方式选择：", "信息查询", 
    			 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
    			 null, options, options[0]);
    	*/		  
    	String searchMethod = (String) JOptionPane.showInputDialog(null,"请选择你的操作:\n",
    			"操作方式选择", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"),
    			options, options[0]);
    	if(searchMethod == options[0])		//用户名查询个人信息
    	{
    		String _name = JOptionPane.showInputDialog(null, "User Name: ", 
    				"Search User Info By Name", JOptionPane.PLAIN_MESSAGE);
    		SearchUserByName(_name);
    	}
    	else if(searchMethod == options[1]){
    		String _id = JOptionPane.showInputDialog(null, "User ID: ", 
    				"Search User Info By ID", JOptionPane.PLAIN_MESSAGE);
    		String[] _ids = _id.split(",");
    		if(_ids.length == 1)		//ID查询个人信息
    		{
    			if(isStr2Num(_ids[0])){
        			SearchUserById(_ids[0]);	
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "输入错误！", "错误提示",
        					JOptionPane.WARNING_MESSAGE);
    			}
    		}
    		else if (_ids.length == 2) {		//ID查询多人信息
    			if(isStr2Num(_ids[0]) && isStr2Num(_ids[1])){
        			UnionSearchUserById(_ids[0], _ids[1]);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "输入错误！", "错误提示",
        					JOptionPane.WARNING_MESSAGE);
    			}
			}
    		else {		//输入有误
    			JOptionPane.showMessageDialog(null, "输入错误！", "错误提示",
    					JOptionPane.WARNING_MESSAGE);
			}
		}
    	else if(searchMethod == options[2]){	//个人信息录入
    		UserVO _userVO = new UserVO();
    		String info = getInput(true);
    		String[] insertInfo = info.split(",");
    		if(insertInfo.length == 0)
    			JOptionPane.showMessageDialog(null, "输入错误！", "错误提示",
    					JOptionPane.WARNING_MESSAGE);
    		else{
    			_userVO.setFirstName(insertInfo[0]);
        		_userVO.setIdUser(Integer.parseInt(insertInfo[1]));
        		_userVO.setLastName(insertInfo[2]);
        		_userVO.setEmail(insertInfo[3]);
    		}
    		if(_userBUS.InfoInput(_userVO))
    			JOptionPane.showMessageDialog(null, "插入成功！", "数据录入提示",
					JOptionPane.WARNING_MESSAGE);
    		else {
    			JOptionPane.showMessageDialog(null, "插入失败！", "数据录入提示",
    					JOptionPane.WARNING_MESSAGE);
			}
    	}
    	else{		//个人信息更改
    		
			String _ID = JOptionPane.showInputDialog(null, "User ID: ", 
    				"Search User Info By Id", JOptionPane.PLAIN_MESSAGE);
			UserVO _userVO = new UserVO();
	        _userVO = _userBUS.getUserById(_ID);	//查询
	        //更新
    		String info = getInput(false);
    		String[] updateInfo = info.split(",");
    		if(updateInfo.length == 0)
    			JOptionPane.showMessageDialog(null, "输入错误！", "错误提示",
    					JOptionPane.WARNING_MESSAGE);
    		else{
    			if(updateInfo[0] != "")
    				_userVO.setFirstName(updateInfo[0]);
    			if(updateInfo[1] != "")
    				_userVO.setLastName(updateInfo[1]);
    			if(updateInfo[2] != "")
    				_userVO.setEmail(updateInfo[2]);
    		}
    		if(_userBUS.InfoUpdate(_userVO))	//根据ID更新个人信息	
    			JOptionPane.showMessageDialog(null, "更新成功！", "数据更新提示",
					JOptionPane.WARNING_MESSAGE);
    		else {
    			JOptionPane.showMessageDialog(null, "更新失败！", "数据更新提示",
    					JOptionPane.WARNING_MESSAGE);
			}
    	}
     }
     
     //判断一段字符串是否能转换为数字
     public boolean isStr2Num(String str) {   
    	 try {  
    		    Integer.parseInt(str);  
    		    return true;  
    		} catch (NumberFormatException e) {  
    		    return false;  
    		}    
     }  
     
     public static void main(String[] args){
    	 frmLogin _frmLogin = new frmLogin();
    	 //String userName = _frmLogin.getInput();
    	 _frmLogin.DoMethod();
     }
}
