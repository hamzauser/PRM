/**
 * 
 */
package serveur;

import java.util.Enumeration;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Diógenes
 *
 */
public class Notification implements Message {

	/* (non-Javadoc)
	 * @see javax.jms.Message#acknowledge()
	 */
	@Override
	public void acknowledge() throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#clearBody()
	 */
	@Override
	public void clearBody() throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#clearProperties()
	 */
	@Override
	public void clearProperties() throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBody(java.lang.Class)
	 */
	@Override
	public <T> T getBody(Class<T> c) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBooleanProperty(java.lang.String)
	 */
	@Override
	public boolean getBooleanProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getByteProperty(java.lang.String)
	 */
	@Override
	public byte getByteProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getDoubleProperty(java.lang.String)
	 */
	@Override
	public double getDoubleProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getFloatProperty(java.lang.String)
	 */
	@Override
	public float getFloatProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getIntProperty(java.lang.String)
	 */
	@Override
	public int getIntProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationID()
	 */
	@Override
	public String getJMSCorrelationID() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationIDAsBytes()
	 */
	@Override
	public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDeliveryMode()
	 */
	@Override
	public int getJMSDeliveryMode() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDeliveryTime()
	 */
	@Override
	public long getJMSDeliveryTime() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDestination()
	 */
	@Override
	public Destination getJMSDestination() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSExpiration()
	 */
	@Override
	public long getJMSExpiration() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSMessageID()
	 */
	@Override
	public String getJMSMessageID() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSPriority()
	 */
	@Override
	public int getJMSPriority() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSRedelivered()
	 */
	@Override
	public boolean getJMSRedelivered() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSReplyTo()
	 */
	@Override
	public Destination getJMSReplyTo() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSTimestamp()
	 */
	@Override
	public long getJMSTimestamp() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSType()
	 */
	@Override
	public String getJMSType() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getLongProperty(java.lang.String)
	 */
	@Override
	public long getLongProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getObjectProperty(java.lang.String)
	 */
	@Override
	public Object getObjectProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getPropertyNames()
	 */
	@Override
	public Enumeration getPropertyNames() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getShortProperty(java.lang.String)
	 */
	@Override
	public short getShortProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getStringProperty(java.lang.String)
	 */
	@Override
	public String getStringProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#isBodyAssignableTo(java.lang.Class)
	 */
	@Override
	public boolean isBodyAssignableTo(Class c) throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#propertyExists(java.lang.String)
	 */
	@Override
	public boolean propertyExists(String name) throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setBooleanProperty(java.lang.String, boolean)
	 */
	@Override
	public void setBooleanProperty(String name, boolean value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setByteProperty(java.lang.String, byte)
	 */
	@Override
	public void setByteProperty(String name, byte value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setDoubleProperty(java.lang.String, double)
	 */
	@Override
	public void setDoubleProperty(String name, double value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setFloatProperty(java.lang.String, float)
	 */
	@Override
	public void setFloatProperty(String name, float value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setIntProperty(java.lang.String, int)
	 */
	@Override
	public void setIntProperty(String name, int value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationID(java.lang.String)
	 */
	@Override
	public void setJMSCorrelationID(String correlationID) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationIDAsBytes(byte[])
	 */
	@Override
	public void setJMSCorrelationIDAsBytes(byte[] correlationID) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDeliveryMode(int)
	 */
	@Override
	public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDeliveryTime(long)
	 */
	@Override
	public void setJMSDeliveryTime(long deliveryTime) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDestination(javax.jms.Destination)
	 */
	@Override
	public void setJMSDestination(Destination destination) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSExpiration(long)
	 */
	@Override
	public void setJMSExpiration(long expiration) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSMessageID(java.lang.String)
	 */
	@Override
	public void setJMSMessageID(String id) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSPriority(int)
	 */
	@Override
	public void setJMSPriority(int priority) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSRedelivered(boolean)
	 */
	@Override
	public void setJMSRedelivered(boolean redelivered) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSReplyTo(javax.jms.Destination)
	 */
	@Override
	public void setJMSReplyTo(Destination replyTo) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSTimestamp(long)
	 */
	@Override
	public void setJMSTimestamp(long timestamp) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSType(java.lang.String)
	 */
	@Override
	public void setJMSType(String type) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setLongProperty(java.lang.String, long)
	 */
	@Override
	public void setLongProperty(String name, long value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setObjectProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObjectProperty(String name, Object value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setShortProperty(java.lang.String, short)
	 */
	@Override
	public void setShortProperty(String name, short value) throws JMSException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setStringProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void setStringProperty(String name, String value) throws JMSException {
		// TODO Auto-generated method stub

	}

}
