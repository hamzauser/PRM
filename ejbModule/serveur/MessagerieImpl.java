/**
 * 
 */
package serveur;

import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * @author hamza
 *
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class MessagerieImpl implements Messagerie {

}
