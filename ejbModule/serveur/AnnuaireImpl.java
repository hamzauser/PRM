/**
 * 
 */
package serveur;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.ejb.Stateless;

/**
 * @author hamza
 *
 */
@Stateless(name = "AnnuaireEJB", mappedName = "AnnuaireImpl")
public class AnnuaireImpl implements Annuaire {

	Collection<Utilisateur> users = new HashSet<Utilisateur>();

	@Override
	public void ajouterUtilisateur(Utilisateur user) throws RemoteException {
		this.users.add(user);
	}

	@Override
	public Collection<Utilisateur> chercherUtilisateur(String nom, String prenom) throws RemoteException {

		Collection<Utilisateur> userSearch = new HashSet<Utilisateur>();
		// System.out.println("Procurando: " + nom);
		if (!this.users.isEmpty()) {
			Iterator<Utilisateur> i = this.users.iterator();

			while (i.hasNext()) {
				Utilisateur aux = (Utilisateur) i.next();

				// System.out.println("Usuario: " + aux.getNom());
				if (nom.compareToIgnoreCase(aux.getNom()) == 0 && prenom.compareToIgnoreCase(aux.getPrenom()) == 0) {
					userSearch.add(aux);
				}
			}
		}

		return userSearch;
	}

	@Override
	public void acceptRefusUtilisateur(Utilisateur users) throws RemoteException {

	}

	@Override
	public boolean supprimerUtilisateur(Utilisateur users) throws RemoteException {
	}
}
