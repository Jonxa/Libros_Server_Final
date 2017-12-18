/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import javax.ejb.Local;
import libros.entity.Password;
import libros.exception.PasswordException;

/**
 * 
 * @author Iker Iglesias
 */
@Local
public interface GestorPasswordBeanLocal {

    public Password getPassword(String user, String password) throws PasswordException;
    
}
