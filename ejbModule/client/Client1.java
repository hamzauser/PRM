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
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author hamza
 *
 */
public class Client1 implements MessageListener{

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JMSException, NamingException, IOException {
		Client1 client1 = new Client1(); 
		Context context = Client1.getInitialContext();
		
		Queue queue01 = (Queue)context.lookup("Queue01");
		Queue queue02 = (Queue)context.lookup("Queue02");
		
		JMSContext jmsContext = ((ConnectionFactory)context.lookup("GFConnectionFactory")).createContext();
		jmsContext.createConsumer(queue02).setMessageListener(client1);
		
		JMSProducer jmsProducer = jmsContext.createProducer();
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Client1 are Connected ....");
		String messageToSend = null;
				
		while(true){
			messageToSend = bufferedReader.readLine();
			
			if (messageToSend.equalsIgnoreCase("exit") ) {
				jmsContext.close();
				System.out.println("GoodBye");
				System.exit(0);
			} else if (messageToSend.contains("a")) {
				
				jmsProducer.send(queue01,"Client 1:"+ messageToSend);
			}
		}
		
	}

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(message.getBody(String.class));
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
}