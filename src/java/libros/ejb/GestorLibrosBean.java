/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import libros.exception.CreateLibroException;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorLibrosBean implements GestorLibrosBeanLocal {
        // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection getAllLibros() {
        return null;
    }

    @Override
    public void createLibro() throws CreateLibroException {
        
    }

    @Override
    public void deleteLibro()  {
        
    }

    @Override
    public void updateLibro() {
        
    }

    @Override
    public Collection busquedaPorISBN(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection busquedaPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection busquedaPorAutor(String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
