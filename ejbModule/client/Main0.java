/**
 * 
 */
package client;

import java.io.IOException;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * @author Diógenes
 *
 */
public class Main0{

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws NamingException 
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws InterruptedException, JMSException, NamingException, IOException {
		
		Thread client1 = new Thread(new Client1());
		Thread client2 = new Thread(new Client2());
		client1.start();
		client2.start();
		client1.join();
		client2.join();
	}
}
