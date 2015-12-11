package serveur;

import java.io.Serializable;
import java.net.UnknownHostException;

import javax.persistence.Embeddable;

import org.bson.types.ObjectId;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author hamza
 *
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class UtilisateurImpl implements Utilisateur, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TODO
	// creer une exception pour auth
	// les tests formalises

	@override
	public boolean inscrire(Personne p) {
		// connexion bdd
		MongoClient client;
		try {
			client = new MongoClient();
			Morphia morphia = new Morphia();
			morphia.map(Personne.class);
			Datastore ds = morphia.createDatastore(client, "utilisateur_EJB");
			ds.ensureIndexes();
			// public Personne(,String Adresse,String Telephone,String
			// Email,ObjectId id){

			// requete d'ajout
			Personne u = new Personne(p.getusername(), p.getpwd(), p.getNom(), p.getPrenom(), p.getAdresse(),
					p.getTelephone(), p.getEmail(), new ObjectId());
			ds.save(u);
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@override
	public DBObject authentification(String user, String pwd) {
		// la recherche
		DBObject t = null;
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient();
			DB db = mongoClient.getDB("utilisateur_EJB");
			DBCollection coll = db.getCollection("Personne");
			DBCursor cursor = coll.find();
			try {
				while (cursor.hasNext()) {
					DBObject h = cursor.next();
					if (h.get("username").toString().equals(user)) {
						if (h.get("pwd").toString().equals(pwd)) {
							System.out.println("connnexion reussi");
							t = h;
							break;
						}
					}
				}
			} finally {
				cursor.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@override
	public boolean Desinscription(String user, String pwd) {

		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient();
			DB db = mongoClient.getDB("utilisateur_EJB");
			DBCollection coll = db.getCollection("Personne");
			// auth genere une exception lorsqu'elle echoue
			coll.remove(authentification(user, pwd));
			System.out.println("C fait");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@override
	public boolean recherche(String user) {
		return false;
	}

}
