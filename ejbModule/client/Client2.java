/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import serveur.DemandeAjout;
import serveur.Utilisateur;
import serveur.UtilisateurImpl;

import javax.jms.ConnectionFactory;

/**
 * @author hamza
 *
 */
public class Client2 extends Thread implements MessageListener{

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 * @throws IOException 
	 */
	static DemandeAjout msgRecu;
	
	public static void main(String[] args) throws JMSException, NamingException, IOException {
		Client2 client2 = new Client2(); 
		Context context = Client2.getInitialContext();
		
		Queue queue01 = (Queue)context.lookup("Queue01");
		Queue queue03 = (Queue)context.lookup("Queue03");
		
		UtilisateurImpl utilisateur = new UtilisateurImpl();
		UtilisateurImpl utilisateur2 = new UtilisateurImpl();
		

		utilisateur.setUserName("Diogenes");
		utilisateur2.setUserName("Oulaya");
		
		DemandeAjout demande = new DemandeAjout(utilisateur, utilisateur2);
		demande.cote = 2;

		
		JMSContext jmsContext = ((ConnectionFactory)context.lookup("GFConnectionFactory")).createContext();
		
		jmsContext.createConsumer(queue03).setMessageListener(client2);
		
		JMSProducer jmsProducer = jmsContext.createProducer();
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
		
		String messageToSend = null;
				
		while(true){
			System.out.println("Client2: ");
			messageToSend = bufferedReader.readLine();
			
			if (messageToSend.equalsIgnoreCase("exit") ) {
				jmsContext.close();
				System.out.println("GoodBye");
				System.exit(0);
			} 
			else if (messageToSend.contains("oui")) {
				
				msgRecu.positive = true;
				msgRecu.response = true;
				msgRecu.cote = 2;
				
				Utilisateur aux = msgRecu.receiver;
				msgRecu.receiver = msgRecu.sender;
				msgRecu.sender = aux;
				
				jmsProducer.send(queue01, msgRecu);
			}
			else if (messageToSend.contains("non")) {
				
				msgRecu.positive = false;
				msgRecu.response = true;
				msgRecu.cote = 2;
				msgRecu.refu = "L'utilisateur ne veut pas t'ajouter";
				
				jmsProducer.send(queue01, msgRecu);
			}
			else if (messageToSend.contains("ajoute")) {
				jmsProducer.send(queue01, demande);
			}
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			msgRecu = message.getBody(DemandeAjout.class);
			
			System.out.println("Cliente2Recu" + msgRecu.receiver.getUserName());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public static Context getInitialContext() throws JMSException, NamingException{
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);
	}
	
	public void run(){
		System.out.println("Client2");
	}
}
