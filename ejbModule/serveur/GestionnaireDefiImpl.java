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

@MessageDriven(activationConfig = { 
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "Queue01"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")}, mappedName = "Queue01")

@Stateless(name = "AnnuaireEJB", mappedName = "AnnuaireImpl")
public class GestionnaireDefiImpl implements GestionnaireDefi, MessageListener {

	@Inject
	JMSContext jmsContext;
	
	@Resource (mappedName = "Queue02")
	Queue queue02; // vers client1
	@Resource (mappedName = "Queue03")
	Queue queue03; // vers client2
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage){
			ObjectMessage om = ((ObjectMessage) message);
			try {
				Class<?> c = om.getObject().getClass();
				if (c == Defi.class){
					System.out.println("tada - defi");
					// determiner la queue d'entree
					Defi object = (Defi) om.getBody(c);
					if (object.cote == 1){
						// on envoi au client2
						object.cote = 11;
						jmsContext.createProducer().send(queue03, object);
						System.out.println("defi envoye a 2");
					}
					else if (object.cote == 2){
						// on envoi au client1
						object.cote = 22;
						jmsContext.createProducer().send(queue02, object);
						System.out.println("defi envoye a 1");
					}
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
