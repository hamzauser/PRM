package serveur;

import java.io.Serializable;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;
import org.mongodb.morphia.annotations.Id;


public class Personne implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id ;
	public String Nom;
	public String Prenom;
	public String Adresse;
	public String Telephone;
	public String Email;
	private String username;
	private String pwd;

	
	public Personne(String username,String pwd,String Nom,String Prenom,String Adresse,String Telephone,String Email,ObjectId id){
		this.Nom = Nom;
		this.Prenom = Prenom ;
		this.Adresse = Adresse;
		this.Telephone = Telephone;
		this.Email = Email;
		this.username = username;
		this.pwd = pwd ;
		this.id = id;
		
		
	}
	
	public static String hashpassword(String s){
		String hashed = BCrypt.hashpw(s, BCrypt.gensalt());
		return hashed;
		//if (BCrypt.checkpw(s, hashed))
		//	  System.out.println("It matches");
		//	else
		//	  System.out.println("It does not match");
	}
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return Prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return Adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return Telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	public String getusername() {
		return username;
	}
	
	public String getpwd() {
		return pwd;
	}
	

}