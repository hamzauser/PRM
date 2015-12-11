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
		return null;
	}

	@override
	public boolean Desinscription(String user, String pwd) {
		return false;
	}

	@override
	public boolean recherche(String user) {
		return false;
	}

}
