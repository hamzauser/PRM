package org.glassfish.JPATest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Todo {
   @Id
   private ObjectId id ; 
   private String task ;
   private Boolean completed = false ; 
   private Date added ;
   private Date finished ;
   @Embedded 
   private User creator ; 
   @Embedded 
   private List <User> users ;
   
   
   
   public Todo(String task,Boolean completed, Date added, User creator, ArrayList<User> users ){
	   this.task = task ;
	   this.completed = false ;
	   this.added = new Date();
	   this.creator = creator ;
	   this.users = new ArrayList<User>();
   }
   }
   
   


