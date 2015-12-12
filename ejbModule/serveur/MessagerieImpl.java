/**
 * 
 */
package serveur;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 * @author hamza
 *
 */
@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "Queue01"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "Queue01")
public class MessagerieImpl implements Messagerie, MessageListener {

//	@Override
//	public boolean envoyer(InstantMessage m) {
//		//
//		return false;
//	}

	@Inject
	JMSContext jmsContext;
	
	@Resource (mappedName = "Queue02")
	Queue queue02;
	@Resource (mappedName = "Queue03")
	Queue queue03;

	@Override
	public boolean notifier(InstantMessage m) {
		// TODO envoi notification
		return false;
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage){
			ObjectMessage om = ((ObjectMessage) message);
			try {
				Class<?> c = om.getObject().getClass();
				if (c == InstantMessage.class){
					//System.out.println("tada - demandeA");
					InstantMessage im = (InstantMessage) message.getBody(c);
					System.out.println(im);
					jmsContext.createProducer().send(queue03, om);
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
