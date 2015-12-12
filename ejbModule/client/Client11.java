/**
 * 
 */
package client;

/**
 * @author Diógenes
 *
 */
public class Client11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread client1 = new Thread(new Client1());
		client1.start();
	}

}
