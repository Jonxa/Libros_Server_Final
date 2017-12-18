/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import libros.entity.Admin;
import libros.exception.AdminNotFoundException;

/**
 * Stateless EJB for managing operations with Administrator entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorAdminBean implements GestorAdminBeanLocal {
     @PersistenceContext
    private EntityManager em;
    //Logger
    private static final Logger logger=Logger.getLogger("libros.ejb.GestorAdminBean");
    
    @Override
    public boolean getAdmin(String user, String password) throws AdminNotFoundException {
        Admin ad=null;
        Boolean existe=false;
        try{
        ad= (Admin) em.createNamedQuery("findByCredential").setParameter("admin",user).setParameter("password", password).getSingleResult();
        if(ad!=null){
            existe=true;
        }
        }catch(Exception e){
           logger.severe("Fallo en la verificacion");
           logger.severe(e.getMessage());
           throw new AdminNotFoundException(e.getMessage());
        }
       return existe;    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
