package model;

import play.db.ebean.Model;

public class User extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 260517376745331639L;
	public String email;
	public String name;

    public User() {
        super();
    }
	
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
