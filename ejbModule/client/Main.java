package client;

import java.io.IOException;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * @author Diógenes
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Thread client1 = new Thread(){
			public void run(){
				try {
					Client1.main(args);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread client2 = new Thread(){
			public void run(){
				try {
					Client2.main(args);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		client1.start();
		client2.start();
		client1.join();
		client2.join();
	}
}