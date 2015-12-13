/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Client2 implements MessageListener {

	/**
	 * @param args
	 * @throws NamingException
	 * @throws JMSException
	 */
	public static void main(String[] args) throws NamingException, JMSException {

		Client2 client2 = new Client2();
		Context context = Client2.getInitialContext();

		Queue queue01 = (Queue) context.lookup("Queue01"); // emission
		Queue queue03 = (Queue) context.lookup("Queue03"); // reception

		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		jmsContext.createConsumer(queue03).setMessageListener(client2);

		JMSProducer jmsProducer = jmsContext.createProducer();

		// envoi du defi
		Defi defi = new Defi();
		defi.cote = 2;
		jmsProducer.send(queue01, defi);

		while (true) {}
	}

	public static Context getInitialContext() throws JMSException, NamingException {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);
	}

	public void repondre() throws IOException, NamingException, JMSException{
		// initialisations
		Context context = Client2.getInitialContext();
		Queue queue01 = (Queue) context.lookup("Queue01"); // emission
		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		JMSProducer jmsProducer = jmsContext.createProducer();
		
		// recuperer l'input
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
		String messageToSend = null;
		messageToSend = bufferedReader.readLine();
		// evoyer le message par rapport a l'input
		if (messageToSend.equalsIgnoreCase("exit")) {
			jmsContext.close();
			System.out.println("GoodBye");
			System.exit(0);
		} else if (messageToSend.contains("oui")) {
			// envoyer reponse positive
			Defi defi = new Defi();
			defi.cote = 2;
			defi.positive = true;
			defi.response = true;
			jmsProducer.send(queue01, defi);
		} else if (messageToSend.contains("non")) {
			// envoyer reponse negative
			Defi defi = new Defi();
			defi.cote = 2;
			defi.positive = false;
			defi.response = true;
			jmsProducer.send(queue01, defi);
		}
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage){
			ObjectMessage om = ((ObjectMessage) message);
			try {
				Class<?> c = om.getObject().getClass();
				if (c == Defi.class){
					Defi object = (Defi) om.getBody(c);
					// System.out.println("tada - defi" + object.cote);
					if (!object.response){
						try {
							repondre();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
