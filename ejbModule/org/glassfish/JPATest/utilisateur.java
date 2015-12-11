package org.glassfish.JPATest;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class utilisateur {
	@Id
	private ObjectId id ;    
	private String noun;
	private String Prenom;

	public utilisateur(String noun , String Prenom , ObjectId id){
		 this.noun = noun;
		 this.Prenom = Prenom;
		 this.id = id;
	}
}
