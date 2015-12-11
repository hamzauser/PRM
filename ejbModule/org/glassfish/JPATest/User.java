package org.glassfish.JPATest;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class User {
	
	@Id
	private ObjectId id ;
	private String login ;
	private String password;

	public User(){
	}
	public User(String login , String password){
		super();
		this.login = login;
		this.password = hashPassword(password);
	}
	private String hashPassword(String input){
		
		/* MD5 suff */
		return input;
	}
}
