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
import libros.entity.Gender;
import libros.exception.BorrarGeneroException;

import libros.exception.BusquedaGeneroException;
import libros.exception.CreateGeneroException;


/**
 * Stateless EJB for managing operations with Gender entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorGenerosBean implements GestorGenerosBeanLocal {
    
     @PersistenceContext
    private EntityManager em;
    //Logger
    private static final Logger logger=Logger.getLogger("libros.ejb.GestorGenerosBean");

    @Override
    public Collection <Gender> getAllGeneros() throws BusquedaGeneroException{
          logger.info("Cogiendo todos los libros de la base de datos");
           Collection <Gender> datos;
       try{
          datos= em.createNamedQuery("findAllGeneros").getResultList();
       }catch(Exception e){
           logger.severe("Fallo al devolver los generos");
           logger.severe(e.getMessage());
           throw new BusquedaGeneroException(e.getMessage());
       }
       return datos;
    }

    @Override
    public void createGenero(Gender create) throws CreateGeneroException,EntityExistsException {
        logger.info("Creando libro");
        try{
              em.persist(create);
              logger.info("Genero creado");
        }catch(IllegalArgumentException e){
            logger.severe("Error al crear genero");
            logger.severe(e.getMessage());
            throw new CreateGeneroException(e.getMessage());
        }catch(TransactionRequiredException w){
            logger.severe("Error al crear genero");
            logger.severe(w.getMessage());
            throw new CreateGeneroException(w.getMessage());
        }
    }

    @Override
    public void deleteGenero(Gender delete) throws BorrarGeneroException{
        logger.info("Borrando libro");
        try{
            em.remove(delete);
            logger.info("Libro borrado");
        }catch(Exception e){
            logger.severe("Error al borrar libro");
            logger.severe(e.getMessage());
            throw new BorrarGeneroException(e.getMessage());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Gender findByID(Integer id) throws BusquedaGeneroException {
        Gender genero;
        
        try{
            genero=em.find(Gender.class, id);
        }catch(Exception e){
            logger.severe("Fallo al devolver genero");
           logger.severe(e.getMessage());
           throw new BusquedaGeneroException(e.getMessage());
        }
        return genero;
    }
}
