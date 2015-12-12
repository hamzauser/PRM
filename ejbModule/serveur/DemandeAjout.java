/**
 * 
 */
package serveur;

/**
 * @author Diógenes
 *
 */
public class DemandeAjout extends Demande {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemandeAjout(Utilisateur receiver, Utilisateur sender){
		this.positive = false;
		this.receiver = receiver;
		this.sender = sender;
		this.response = false;
		this.cote = 0;
		this.refu = "";
	}
}
