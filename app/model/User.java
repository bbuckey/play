package model;

public class User {
	
	public String email;
	public String name;
	
	public User() {;}
	
	public User(String _email , String _name){
		email = _email;
		name = _name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getName(){
		return this.name;
	}

}
