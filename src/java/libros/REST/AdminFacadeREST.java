/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;


import javax.ejb.Stateless;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;
import javax.ejb.EJB;
import libros.ejb.GestorAdminBeanLocal;
import libros.exception.AdminNotFoundException;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Path("admin")
public class AdminFacadeREST {

     private static final Logger logger=Logger.getLogger("libros.REST.AdminFacadeREST");
     
     @EJB
     private GestorAdminBeanLocal ejb;


    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Boolean find(@PathParam("admi") String admi,@PathParam("pass") String pass) {
        Boolean existe=false;
        try{
            existe=ejb.getAdmin(admi, pass);
        }catch(AdminNotFoundException ex){
            logger.severe("Fallo al comprobar administrador");
            logger.severe(ex.getMessage());
        } 
       return existe;
    }
}
