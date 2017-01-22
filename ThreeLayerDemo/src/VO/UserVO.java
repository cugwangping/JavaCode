package VO;

public class UserVO {
	private String _firstName;
	private int _idUser;
	private String _lastName;
	private String _email;
	
	// <constructor>
    // Constructor UserVO
	public UserVO(){
		
	}
	
	public void setIdUser(int idUser){
		this._idUser = idUser;
	}
	
	public int getIdUser(){
		return this._idUser;
	}
	
	public void setFirstName(String firstName){
		this._firstName = firstName;
	}
	
	public String getFirstName(){
		return this._firstName;
	}
	
	public void setLastName(String lastName){
		this._lastName = lastName;
	}
	
	public String getLastName(){
		return this._lastName;
	}
	
	public void setEmail(String email){
		this._email = email;
	}
	
	public String getEmail(){
		return this._email; 
	}
}
