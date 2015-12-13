/**
 * 
 */
package serveur;

import java.io.Serializable;

/**
 * @author hamza
 *
 */
public class InstantMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Utilisateur sender;
	public Utilisateur receiver;
	public String content;
	public int cote = 0;
	
	@Override
	public String toString(){
		return content;
		
	}

}
