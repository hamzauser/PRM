/**
 * 
 */
package serveur;

import java.io.Serializable;

/**
 * @author Diógenes
 *
 */
public class Resultat implements Serializable{ 
     private static final long serialVersionUID = 1L;
	
	public Utilisateur u1; // celui qui lance le defi
	public Utilisateur u2; // celui qui est defie
	public boolean response = false;
	public boolean positive = false;
	public int score = 0;
	public String res;
	public int cote = 0;
	public boolean valide = false;
	
	
	/**
	 * constructeur par defaut
	 */
	public Resultat(){}
	
	public Resultat(Utilisateur u1, Utilisateur u2, boolean response, boolean positive) {
		super();
		this.u1 = u1;
		this.u2 = u2;
		this.response = response;
		this.positive = positive;
	}

}
