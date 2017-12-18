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

 /**
  * Method that gets user credentials
  * @param user
  * @param password
  * @return
  * @throws PasswordException 
  */
    @Override
    public Password getPassword(String user, String password) throws PasswordException {
        logger.info("Getting user password");
        Password pass = null;
        try{
        pass= (Password) em.createNamedQuery("findPasswordByUser").setParameter("usuario", user).setParameter("password", pass).getSingleResult();
        }
        catch(Exception e){
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new PasswordException(e.getMessage());
        }
        return pass;
    }

    
}
