/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import libros.exception.GeneroException;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 2dam
 */
@Local
public interface GestorGenerosBeanLocal {
    
     public Collection getAllGeneros();
     public void createGenero() throws GeneroException;
     public void deleteGenero() throws GeneroException;
}
