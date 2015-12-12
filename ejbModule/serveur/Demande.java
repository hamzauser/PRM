/**
 * 
 */
package serveur;

import java.io.Serializable;

/**
 * @author Diógenes
 *
 */
public class Demande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean response;
	public Utilisateur sender;
	public Utilisateur receiver;
	public boolean positive;
	public int cote;
	public String refu;
}
