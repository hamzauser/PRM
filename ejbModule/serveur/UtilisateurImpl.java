package serveur;


import java.io.Serializable;

/**
 * @author hamza
 *
 */
//@Entity
public class UtilisateurImpl implements Utilisateur {

	private static final long serialVersionUID = 1L;
	
	public Personne user = new Personne();
	
	public boolean inscrire(Personne p){
		//connexion bdd
//		@Column( name = "")
		
		//requete d'ajout
		return false;
	}
	
	public class Personne implements Serializable {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public String Nom;

		public String Prenom;

		public String Adresse;

		public String Telephone;

		public String Email;

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

	}

}
