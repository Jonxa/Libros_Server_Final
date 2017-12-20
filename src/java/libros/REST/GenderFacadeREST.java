/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import libros.ejb.GestorGenerosBeanLocal;
import libros.entity.Gender;
import libros.exception.BorrarGeneroException;
import libros.exception.BusquedaGeneroException;
import libros.exception.CreateGeneroException;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityExistsException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import libros.exception.BusquedaLibroException;

/**
 *
 * @author 2dam
 */
@Path("gender")
public class GenderFacadeREST {
 private static final Logger logger=Logger.getLogger("libros.REST.GenderFacadeREST");
     
     @EJB
     private GestorGenerosBeanLocal ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Gender entity) {
        logger.info("Creando Genero");
         try {
             ejb.createGenero(entity);
             logger.info("Genero creado");
         } catch (CreateGeneroException ex) {
             logger.severe("No se pudo crear genero");
         }
    }


    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        logger.info("Borrando genero");
         try {
             ejb.deleteGenero(ejb.findByID(id)); 
             logger.info("Genero borrado");
         } catch (BorrarGeneroException ex) {
             logger.severe("Error al borrar");
         } catch (BusquedaGeneroException ex) {
             logger.severe("No se encontro el genero");
         }
    }
    
      @GET
     @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Gender findByID(@PathParam ("id") Integer id){
        Gender genero = null;
        logger.info("Buscando libro por codigo");
         try {
             genero=  ejb.findByID(id);
             logger.info("Procediendo a devolver libros");
         } catch (BusquedaGeneroException ex) {
              logger.severe("Fallo en la busqueda de libros");
              logger.severe(ex.getMessage());
         }
         return genero;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Gender> findAll() {
        Collection generos = null;
        logger.info("Buscando todos los generos");
         try {
             generos= ejb.getAllGeneros();
             logger.info("Procediendo a devolver generos");
         } catch (BusquedaGeneroException ex) {
            logger.severe("Fallo en la busqueda de generos");
            logger.severe(ex.getMessage());
         }
         return generos;
    }
    
}
