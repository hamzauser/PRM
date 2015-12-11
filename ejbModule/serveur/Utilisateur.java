package serveur;

import java.io.Serializable;

import com.mongodb.DBObject;

public interface Utilisateur extends Serializable{
	/**
	 * Methode d'incription d'un utilisateur.
	 * Serialise directement l'instance de personne dans la base de donnees.
	 * @param p
	 * @return success
	 */
	public boolean inscrire(Personne p);
	/**
	 * Methode d'authentification d'un utilisaeur.
	 * Verifie si les informations user et pwd sont exactes.
	 * @param user
	 * @param pwd
	 * @return dbobject
	 */
	public DBObject authentification(String user, String pwd);
	/**
	 * Methode de desincription d'un utilisateur.
	 * Retire " l'entree personne correspondante " dans la base de donnees.
	 * L'utilisateur doit s'authentifier avant de se desincrire.
	 * @param user
	 * @param pwd
	 * @return success
	 */
	public boolean Desinscription(String user, String pwd);
	/**
	 * Methode de recherche par nom d'utilisateur.
	 * @param user
	 * @return success
	 */
	public boolean recherche(String user);
}
