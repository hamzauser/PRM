/**
 * 
 */
package client;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import serveur.Defi;

/**
 * @author Diógenes
 *
 */
public class Client1 implements MessageListener {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws NamingException, JMSException {
		
		Client1 client1 = new Client1();
		Context context = Client1.getInitialContext();
		
		Queue queue01 = (Queue) context.lookup("Queue01"); // emission
		Queue queue02 = (Queue) context.lookup("Queue02"); // reception

		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		jmsContext.createConsumer(queue02).setMessageListener(client1);

		JMSProducer jmsProducer = jmsContext.createProducer();
		
		// envoi du defi
		Defi defi = new Defi();
		defi.cote = 1;
		jmsProducer.send(queue01, defi);
		
		while(true){}
	}
	
	public static Context getInitialContext() throws JMSException, NamingException {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage){
			ObjectMessage om = ((ObjectMessage) message);
			try {
				Class<?> c = om.getObject().getClass();
				if (c == Defi.class){
					Defi object = (Defi) om.getBody(c);
					System.out.println("tada - defi" + object.cote);
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
