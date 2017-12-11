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
import javax.persistence.TransactionRequiredException;
import libros.entity.User;
import libros.exception.CompraException;
import libros.exception.CreateCompraException;
import libros.exception.CreateUserException;
import libros.exception.DeleteUserException;
import libros.exception.UpdateUserException;
import libros.exception.UserException;

/**
 *  Stateless EJB for managing operations with User entities.
 * @author 2dam
 */
@Stateless
public class GestorUserBean implements GestorUserBeanLocal {
    private static final Logger logger =Logger.getLogger("libros.ejb.GestorUserBean");
    @PersistenceContext
    private EntityManager em;

     
    @Override
    public User getUser(String user, String password) throws UserException {
        logger.info("Getting user");
        User us;
         try{
          us= (User) em.createNamedQuery("findUserData").setParameter("usuario", user).getResultList();
        }
        catch(Exception e){
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new UserException(e.getMessage());
        }
         return us;
    }

    @Override
    public void createUser(User user) throws CreateUserException {
        logger.info("Creating user");
          try{
              em.persist(user);
              logger.info("Compra creada");
        }catch(IllegalArgumentException e){
            logger.severe("Error al crear usuario");
            logger.severe(e.getMessage());
            throw new CreateUserException(e.getMessage());
        }catch(TransactionRequiredException w){
            logger.severe("Error al crear usuario");
            logger.severe(w.getMessage());
            throw new CreateUserException(w.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) throws DeleteUserException {
        logger.info("Deleting user");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User user) throws UpdateUserException {
        logger.info("Updating user");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
