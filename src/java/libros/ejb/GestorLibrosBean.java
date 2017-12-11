/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.ArrayList;
import libros.exception.CreateLibroException;
import libros.exception.BusquedaLibroException;
import libros.exception.CreateLibroException;
import libros.exception.ActualizarLibroException;
import libros.exception.BorrarLibroException;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import libros.entity.Book;

/**
 * Stateless EJB for managing operations with Book entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorLibrosBean implements GestorLibrosBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    //Logger
    private static final Logger logger=Logger.getLogger("libros.ejb.GestorLibrosBean");
    
    
    
    /**
     * Get all the books from the database.
     * @return Book Collection
     * @throws LibroException 
     */
    @Override
    public Collection getAllLibros() throws BusquedaLibroException{
        logger.info("Cogiendo todos los libros de la base de datos");
       try{
          return em.createNamedQuery("findAllLibros").getResultList();
       }catch(Exception e){
           logger.severe("Fallo al devolver los libros");
           logger.severe(e.getMessage());
           throw new BusquedaLibroException(e.getMessage());
       }
   
    }

    @Override
    public void createLibro(Book create) throws CreateLibroException,EntityExistsException {
        logger.info("Creando libro");
        try{
              em.persist(create);
              logger.info("Libro creado");
        }catch(IllegalArgumentException e){
            logger.severe("Error al crear libro");
            logger.severe(e.getMessage());
            throw new CreateLibroException(e.getMessage());
        }catch(TransactionRequiredException w){
            logger.severe("Error al crear libro");
            logger.severe(w.getMessage());
            throw new CreateLibroException(w.getMessage());
        }
    }

    @Override
    public void deleteLibro(Book delete) throws BorrarLibroException{
        logger.info("Borrando libro");
        try{
            em.remove(delete);
            logger.info("Libro borrado");
        }catch(Exception e){
            logger.severe("Error al borrar libro");
            logger.severe(e.getMessage());
            throw new BorrarLibroException(e.getMessage());
        }
        
    }

    @Override
    public void updateLibro(Book update) throws ActualizarLibroException {
        logger.info("Actualizando libro");
        try{
            em.merge(update);
            logger.info("Libro Actualizado");  
        }catch(Exception e){
            logger.severe("Fallo al actualizar");
            logger.severe(e.getMessage());
            throw new ActualizarLibroException(e.getMessage());
        }
    }

    @Override
    public Collection busquedaPorISBN(String isbn)throws BusquedaLibroException {
        logger.info("Buscando por isbn");
        try{
            return em.createNamedQuery("findLibrosByIsbn").setParameter("isbn", isbn).getResultList();
        }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
      
    }

    @Override
    public Collection busquedaPorTitulo(String titulo) throws BusquedaLibroException {
        logger.info("Buscando por nombre");
        try{
            return em.createNamedQuery("findLibrosByTitulo").setParameter("titulo",titulo).getResultList();
        }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
    }

    @Override
    public Collection busquedaPorAutor(String autor) throws BusquedaLibroException {
         logger.info("Buscando por autor");
         try{
            return em.createNamedQuery("findLibrosByAutor").setParameter("autor",autor).getResultList();
         }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
    }
}
