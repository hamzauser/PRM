package client;

import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class damande_ajout implements MessageListener {

	@Override
	public void onMessage(Message message){
		try {
			System.out.println(message.getBody(String.class));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void main(String[] arg) throws JMSException, NamingException {
		damande_ajout damande_ajout = new damande_ajout();
		Context context = damande_ajout.getInitialContext();
		Queue queue1 = (Queue)context.lookup("Queue1");
		Queue queue2 = (Queue)context.lookup("Queue2");
		JMSContext jmsContext =((ConnectionFactory)context.lookup("jms/GestionnaireDe")).createContext();
		jmsContext.createConsumer(queue2).setMessageListener(damande_ajout);
		
		
	}
	public static Context getInitialContext() throws JMSException ,NamingException {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url","iiop://localhost:3700");
		return new InitialContext(properties);
		
		
	}
	

}
