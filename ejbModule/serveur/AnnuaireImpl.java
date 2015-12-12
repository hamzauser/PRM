/**
 * 
 */
package serveur;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 * @author hamza
 *
 */

@MessageDriven(activationConfig = { 
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "Queue01"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")}, mappedName = "Queue01")

@Stateless(name = "AnnuaireEJB", mappedName = "AnnuaireImpl")
public class AnnuaireImpl implements Annuaire, MessageListener {
	
	@Inject
	JMSContext jmsContext;
	
	@Resource (mappedName = "Queue02")
	Queue queue02;
	@Resource (mappedName = "Queue03")
	Queue queue03;

	Collection<Utilisateur> users = new HashSet<Utilisateur>();

	@Override
	public void ajouterUtilisateur(Utilisateur user) throws RemoteException {
		this.users.add(user);
	}

	@Override
	public Collection<Utilisateur> chercherUtilisateur(String nom, String prenom) throws RemoteException {

		Collection<Utilisateur> userSearch = new HashSet<Utilisateur>();
		if (!this.users.isEmpty()) {
			Iterator<Utilisateur> i = this.users.iterator();

			while (i.hasNext()) {
				Utilisateur aux = (Utilisateur) i.next();

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

		boolean existe = false;

		if (!this.users.isEmpty()) {
			Iterator<Utilisateur> i = this.users.iterator();

			while (i.hasNext()) {
				Utilisateur aux = (Utilisateur) i.next();

				if (users.getNom().compareToIgnoreCase(aux.getNom()) == 0
						&& users.getPrenom().compareToIgnoreCase(aux.getPrenom()) == 0) {

					existe = true;
					i.remove();
				}
			}

			if (!existe) {
				System.out.println("Utilisateur n existe pas!!!!");
				return true;
			}
		}

		System.out.println("Utilisateur n existe pas!!!!");
		return false;
	}

	@Override
	public void demandeDajout(Utilisateur user) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage){
			ObjectMessage om = ((ObjectMessage) message);
			
			try {
				Class<?> c = om.getObject().getClass();
				
				if (c == DemandeAjout.class){
					DemandeAjout demande = message.getBody(DemandeAjout.class);
					
					if(demande.cote == 1){
						jmsContext.createProducer().send(queue03, demande);
						System.out.println("lado 1 pede para adicionar 2");
					}
					
					else if(demande.cote == 2){
						jmsContext.createProducer().send(queue02, demande);
						System.out.println("lado 2 pede para adicionar 1");
					}
					
					else if (demande.positive && demande.response){
						System.out.println(demande.receiver.getUserName());
						
						//ajouter dans la base de donnee
					}
					
					else if(!demande.positive && demande.response && demande.cote == 1){
						jmsContext.createProducer().send(queue03, demande);
						System.out.println("lado 1 recusa adicionar 2");
					}
					
					else if(!demande.positive && demande.response && demande.cote == 2){
						jmsContext.createProducer().send(queue02, demande);
						System.out.println("lado 2 recusa adicionar 2");
					}
				}
				
				else if (c == Utilisateur.class){
					System.out.println("tada - user");
				}
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
