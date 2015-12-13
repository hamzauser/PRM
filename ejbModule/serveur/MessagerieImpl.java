/**
 * 
 */
package serveur;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
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

@Stateless(name = "AnnuaireEJB", mappedName = "AnnuaireImpl")
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
					InstantMessage im = (InstantMessage) message.getBody(c);
					
					if(im.cote == 1){
						jmsContext.createProducer().send(queue03, im);
					}
					else if(im.cote == 2){
						jmsContext.createProducer().send(queue02, im);
					}
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
