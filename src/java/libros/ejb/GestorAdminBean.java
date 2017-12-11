/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import javax.ejb.Stateless;
import libros.entity.Admin;
import libros.exception.AdminNotFoundException;

/**
 * Stateless EJB for managing operations with Administrator entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorAdminBean implements GestorAdminBeanLocal {

    @Override
    public Admin getAdmin(String user, String password) throws AdminNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
