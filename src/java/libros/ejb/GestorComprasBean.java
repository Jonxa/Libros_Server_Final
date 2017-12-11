/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import libros.entity.Purchase;
import libros.entity.User;
import libros.exception.CompraException;
import libros.exception.CreateCompraException;
import libros.exception.DeleteCompraException;
import libros.exception.UpdateCompraException;

/**
 * Stateless EJB for managing operations with Purchase entities.
 * @author Iker Iglesias
 */
@Stateless
public class GestorComprasBean implements GestorComprasBeanLocal {
     private static final Logger logger =Logger.getLogger("libros.ejb.GestorComprasBean");
     @PersistenceContext
     private EntityManager em;

     /**
      * Method that returns every book purchased by an user.
      * @param usuario
      * @return compras collection of user purchases.
      * @throws CompraException 
      */
    @Override
    public Collection getAllCompras(User usuario) throws CompraException {
        logger.info("Getting all the purchases");
        Collection <Purchase> datos;
        try{
        datos=em.createNamedQuery("findVentasByUser").setParameter("usuario", usuario).getResultList();
        }
        catch(Exception e){
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new CompraException(e.getMessage());
        }
        return datos;
    }
   
    
    @Override
    public void createCompra(Purchase purchases) throws CreateCompraException {
        logger.info("Doing a purchase");
  
        try{
              em.persist(purchases);
              logger.info("Compra creada");
        }catch(Exception e){
            logger.severe("Error al crear compra");
            logger.severe(e.getMessage());
            throw new CreateCompraException(e.getMessage());
        }
    }
  
    @Override
    public void deleteCompra(Purchase purchases) throws DeleteCompraException {
         logger.info("Deleting purchase");
        try{
              em.remove(purchases);
              logger.info("Compra borrada");
        }catch(Exception e){
            logger.severe("Error al borrar compra");
            logger.severe(e.getMessage());
            throw new DeleteCompraException(e.getMessage());
        }
    }

    @Override
    public void updateCompra(Purchase purchases) throws UpdateCompraException {
         logger.info("Updating purchase");
            try{
              em.merge(purchases);
              logger.info("Compra modificada");
        }catch(Exception e){
            logger.severe("Error al modificar compra");
            logger.severe(e.getMessage());
            throw new UpdateCompraException(e.getMessage());
        }
    }

    
    
}
