/**
 * 
 */
package serveur;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mongodb.MongoClient;

/**
 * @author hamza
 *
 */
@Stateless
public class AnnuaireImpl implements Annuaire {
	
	Collection <Utilisateur> user = new HashSet<Utilisateur>();
	
	@Override
	public void ajouterUtilisateur(Utilisateur user) throws RemoteException {
		
		this.user.add(user);
	}

	@Override
	public Collection<Utilisateur> chercherUtilisateur(String Nom, String prenom) throws RemoteException {
		
		Collection <Utilisateur> userSearch = new HashSet<Utilisateur>();
		
		if(!this.user.isEmpty()){
			
			while(this.user.iterator().hasNext()){
				
				Utilisateur aux = this.user.iterator().next();
				
				if(aux.getNom() == Nom && aux.getPrenom()==prenom){
					userSearch.add(aux);
				}
			}
		}
		
		return userSearch;
	}

	@Override
	public void acceptRefusUtilisateur(Utilisateur user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur user) throws RemoteException {
		
		boolean existe = false;
		
		if(!this.user.isEmpty()){
			
			while(this.user.iterator().hasNext()){
				
				Utilisateur aux = this.user.iterator().next();
				
				if(aux.equals(user)){
					System.out.println("Utilisateur " + aux.getPrenom() + "supprimer avec succès!!");
					existe = true;
					this.user.remove(aux);
				}
			}
			
			if(!existe)
				System.out.println("Utilisateur n'existe pas!!!!");
		}
		
		else
			System.out.println("Utilisateur n'existe pas!!!!");
	}
}
