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

import serveur.Resultat;

/**
 * @author Diógenes
 *
 */
public class Client20 implements MessageListener {

	/**
	 * @param args
	 * @throws NamingException
	 * @throws JMSException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JMSException, NamingException, IOException {
		Client20 client2 = new Client20();

		Context context = Client20.getInitialContext();

		Queue queue03 = (Queue) context.lookup("Queue03"); // reception

		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		jmsContext.createConsumer(queue03).setMessageListener(client2);

		// envoi du resulat
		/*
		 * Resultat Resultat = new Resultat(); Resultat.cote = 1;
		 * jmsProducer.send(queue01, Resultat);
		 */

		while (true) {
			// nettoyer la console
		}
	}

	public static Context getInitialContext() throws JMSException, NamingException {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);
	}

	public static void saisirResultat() throws JMSException, NamingException, IOException {
		// initialisations
		Context context = Client20.getInitialContext();
		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		JMSProducer jmsProducer = jmsContext.createProducer();
		Queue queue01 = (Queue) context.lookup("Queue01"); // emission

		System.out.println("saisir resultat");

		// recuperer l'input
		// verifier si l'input est correct
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
		String messageToSend = null;
		messageToSend = bufferedReader.readLine();
		// evoyer le message par rapport a l'input
		if (messageToSend.equalsIgnoreCase("exit")) {
			jmsContext.close();
			System.out.println("GoodBye");
			System.exit(0);
		} else if (messageToSend.contains("-")) {
			// recuperer le score
			// envoyer le resultat
			Resultat result = new Resultat();
			result.cote = 1;
			result.response = false;
			result.res = messageToSend;
			jmsProducer.send(queue01, result);
		} else {
			// sortir de la fonction
		}
	}

	public void repondreResultat() throws IOException, NamingException, JMSException {
		// initialisations
		Context context = Client20.getInitialContext();
		JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
		JMSProducer jmsProducer = jmsContext.createProducer();
		Queue queue01 = (Queue) context.lookup("Queue01"); // emission
		
		System.out.println("reponse :");

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
			Resultat resultat = new Resultat();
			resultat.cote = 2;
			resultat.positive = true;
			resultat.response = true;
			jmsProducer.send(queue01, resultat);
		} else if (messageToSend.contains("non")) {
			// envoyer reponse negative
			Resultat resultat = new Resultat();
			resultat.cote = 2;
			resultat.positive = false;
			resultat.response = true;
			jmsProducer.send(queue01, resultat);
		}
	}
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage om = ((ObjectMessage) message);
			try {
				// Resultat
				Class<?> c = om.getObject().getClass();
				if (c == Resultat.class) {
					Resultat object = (Resultat) om.getBody(c);
					System.out.println("tada - Resultat" + object.cote);
					if (object.response) {
						// System.out.println(" resultat valide == " +
						// object.positive);
					} else if (!object.response) {
						try {
							repondreResultat();
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
