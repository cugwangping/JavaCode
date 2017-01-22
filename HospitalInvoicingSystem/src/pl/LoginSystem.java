package pl;

import bus.ProcedureCall;
import bus.UserManager;
import jList.MyJList;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginSystem {
 
	 //初始化
	 public LoginSystem() {
		// TODO Auto-generated constructor stub
	}
	 
	 public boolean UserLogin() {
		Object[] options ={ "用户登录" }; 	  
    	JOptionPane.showInputDialog(null,"请选择你的操作:\n",
    			"操作方式选择", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"),
    			options, options[0]);
    	//用户登录
		String _name = JOptionPane.showInputDialog(null, "User Name: ", 
				"用户登录", JOptionPane.PLAIN_MESSAGE);
		boolean is_login=UserManager.connect(_name);
		if(is_login){
			JOptionPane.showMessageDialog(null, "登录成功", "登录响应",JOptionPane.PLAIN_MESSAGE);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "登录失败", "登录响应",JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
     public void DoMethod(){
    	 Object[] options ={ "药品采购统计查询", "药品基本信息查询", "客户基本信息查询", "药品库存盘点信息查询" 
    			 , "用户信息查询", "药品销售信息查询"};	  
    	String searchMethod = (String) JOptionPane.showInputDialog(null,"请选择你的操作:\n",
    			"操作方式选择", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"),
    			options, options[0]);
    	ProcedureCall pro=new ProcedureCall();
    	Connection conn=pro.connect();
    	if(searchMethod == options[0])		//查询药品采购统计信息
    	{
    		String result = pro.YAOPINRUKU_PRO(conn);
    		JOptionPane.showMessageDialog(null, result, "统计结果",JOptionPane.PLAIN_MESSAGE);
    	}
    	else if(searchMethod == options[1]){
    		String _name = JOptionPane.showInputDialog(null, "药品名称: ", 
    				"根据药品名称查询药品信息", JOptionPane.PLAIN_MESSAGE);
    		pro.YAOPIN_PRO(conn, _name);
    	}
    	else if(searchMethod == options[2]){
    		String _name = JOptionPane.showInputDialog(null, "客户名称: ", 
    				"根据客户名称查询客户信息", JOptionPane.PLAIN_MESSAGE);
    		pro.YAOPIN_PRO(conn, _name);
    	}
    	else if(searchMethod == options[3]){
    		String _name = JOptionPane.showInputDialog(null, "药品盘点日期: ", 
    				"根据药品盘点日期查询药品盘点信息", JOptionPane.PLAIN_MESSAGE);
    		pro.YAOPIN_PRO(conn, _name);
    	}
    	else if(searchMethod == options[4]){
    		String _name = JOptionPane.showInputDialog(null, "用户名称: ", 
    				"根据用户名称查询用户信息", JOptionPane.PLAIN_MESSAGE);
    		pro.YAOPIN_PRO(conn, _name);
    	}
    	else if(searchMethod == options[5]){
    		String _name = JOptionPane.showInputDialog(null, "销售流水号: ", 
    				"根据销售流水号查询药品销售信息", JOptionPane.PLAIN_MESSAGE);
    		pro.YAOPIN_PRO(conn, _name);
    	}
     }
     
     public static void main(String[] args){
    	 LoginSystem ls = new LoginSystem();
    	 boolean is_login=ls.UserLogin();
    	 if(is_login)
    		 ls.DoMethod();
    	 else {
			System.out.println("用户登录失败，退出系统");
		}
     }
}

