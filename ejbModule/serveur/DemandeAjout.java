/**
 * 
 */
package serveur;

/**
 * @author Di�genes
 *
 */
public class DemandeAjout extends Demande {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemandeAjout(Utilisateur receiver, Utilisateur sender){
//		System.out.println("machin chose");
		this.positive = false;
		this.receiver = receiver;
		this.sender = sender;
		this.response = false;
	}
}
