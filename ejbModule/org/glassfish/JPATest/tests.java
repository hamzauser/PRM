package org.glassfish.JPATest;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class tests {
	
	private EntityManagerFactory entityManagerFactory;
	private  EntityManager entityManager;

	@Before
	public void setUp() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("mongodb");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void tearDown() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void add(){
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("utilisateur");
		}
	
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		MongoClient client = new MongoClient();
		Morphia morphia =new Morphia();
		morphia.map(utilisateur.class);
		Datastore ds = morphia.createDatastore(client, "utilisateur");
		ds.ensureIndexes();
		
		//Todo todo ;
		//User john = new User("John","smith");
		//User jack = new User("Jack","harkness");
		//User rose = new User("Rose", "tyler");
		//ArrayList<User> users = new ArrayList<User>();
		//users.add(rose) ; users.add(jack);
		//todo = new  Todo("Istall Eclipse" , new Random().nextBoolean() , new Date() ,john,users);
		
		utilisateur u = new utilisateur("hamza","baqa",new ObjectId());
		
		
		//ds.save(todo);
		ds.save(u);
		
		

	}

}
