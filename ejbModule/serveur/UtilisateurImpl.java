/**
 * 
 */
package serveur;

/**
 * @author hamza
 *
 */
public class UtilisateurImpl implements Utilisateur {

	String nom = "", prenom = "", addresse = "", telephone = "", email = "",username ="";
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getNom() {
		return this.nom;
	}
	
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getPrenom() {
		return this.prenom;
	}

	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String getAdresse() {
		return this.addresse;
	}

	@Override
	public void setAdresse(String adresse) {
		this.addresse = adresse;
	}

	@Override
	public String getTelephone() {
		return this.telephone;
	}

	@Override
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public void setUserName(String user) {
		this.username = user;
	}


	@Override
	public String getUserName() {
		return this.username;
	}
}
