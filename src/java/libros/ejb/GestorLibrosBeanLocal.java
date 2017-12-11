/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import exception.CreateLibroException;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 2dam
 */
@Local
public interface GestorLibrosBeanLocal {
    
    public Collection getAllLibros();
    public void createLibro() throws CreateLibroException;
    public void deleteLibro();
    public void updateLibro();
    public Collection busquedaPorISBN(String isbn);
    public Collection busquedaPorNombre(String nombre);
    public Collection busquedaPorAutor(String autor);
    
}
