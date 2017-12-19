/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import libros.exception.CreateGeneroException;
import java.util.Collection;
import javax.ejb.Local;
import libros.entity.Gender;
import libros.exception.BorrarGeneroException;
import libros.exception.BusquedaGeneroException;

/**
 *
 * @author 2dam
 */
@Local
public interface GestorGenerosBeanLocal {
    
     public Collection <Gender> getAllGeneros() throws BusquedaGeneroException;
     public void createGenero(Gender create) throws CreateGeneroException;
     public void deleteGenero(Gender delete) throws BorrarGeneroException;
     public Gender findByID(Integer id) throws BusquedaGeneroException;
}
