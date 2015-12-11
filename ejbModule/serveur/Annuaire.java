/**
 * 
 */
package serveur;

import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.Remote;

/**
 * @author hamza
 *
 */
@Remote
public interface Annuaire {

	/**
	 * Methode d'ajout d'un utilisateur a l'annuaire.
	 * @param user
	 * @throws RemoteException
	 */
	public void ajouterUtilisateur(Utilisateur user) throws RemoteException;

	/**
	 * Methode de recherche d'un utilisateur.
	 * Cherche les utilisateurs partageant les memes noms et prenom recherches.
	 * @param Nom
	 * @param prenom
	 * @return utilisateurs dont les informations correspondent.
	 * @throws RemoteException
	 */
	public Collection<Utilisateur> chercherUtilisateur(String Nom, String prenom) throws RemoteException;

	/**
	 * 
	 * @param user
	 * @throws RemoteException
	 */
	public void acceptRefusUtilisateur(Utilisateur user) throws RemoteException;

	/**
	 * Methode de suppression d'un utilisateur.
	 * @param user
	 * @return success
	 * @throws RemoteException
	 */
	public boolean supprimerUtilisateur(Utilisateur user) throws RemoteException;
}
