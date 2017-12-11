/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import libros.entity.Password;
import libros.exception.PasswordException;


/**
 *  Stateless EJB for managing operations with Password entities.
 * @author Iker Iglesias
 */
@Stateless
public class GestorPasswordBean implements GestorPasswordBeanLocal {
   private static final Logger logger =Logger.getLogger("libros.ejb.GestorPasswordBean");
    @PersistenceContext
   private EntityManager em;


    @Override
    public Password getPassword(String user, String password) throws PasswordException {
        logger.info("Getting user password");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
