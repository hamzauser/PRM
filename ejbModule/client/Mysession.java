package client;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Mysession
 */
@Stateless
@LocalBean
public class Mysession implements MysessionRemote, MysessionLocal {

    /**
     * Default constructor. 
     */
    public Mysession() {
        // TODO Auto-generated constructor stub
    }

}
