/**
 * 
 */
package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * @author hamza
 *
 */
public interface Annuaire extends Remote{
	
		public void ajouterUtilisateur (Utilisateur user) throws RemoteException;
		public Collection <Utilisateur> chercherUtilisateur(String Nom, String prenom)
		throws RemoteException;
		public void acceptRefusUtilisateur ( Utilisateur user) throws RemoteException;
		public void supprimerUtilisateur(Utilisateur user) throws
		RemoteException;
		}


