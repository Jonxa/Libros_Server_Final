/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;


import libros.exception.AdminNotFoundException;
import javax.ejb.Local;
import libros.entity.Admin;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Local
public interface GestorAdminBeanLocal {
    
    public boolean getAdmin(String user,String password) throws AdminNotFoundException;
    
}
