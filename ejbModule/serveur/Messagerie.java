/**
 * 
 */
package serveur;

import java.rmi.Remote;

/**
 * @author hamza
 *
 */
public interface Messagerie extends Remote{
	/**
	 * Methode d'envoi de messages instantanees.
	 * @param m
	 * @return success
	 */
//	public boolean envoyer(InstantMessage m);
	/**
	 * Notification asynchrone.
	 * @param m
	 * @return success
	 */
	public boolean notifier(InstantMessage m);
}
