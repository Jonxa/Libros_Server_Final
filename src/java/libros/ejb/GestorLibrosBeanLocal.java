/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import libros.exception.BusquedaLibroException;
import libros.exception.CreateLibroException;
import libros.exception.ActualizarLibroException;
import libros.exception.BorrarLibroException;
import java.util.Collection;
import javax.ejb.Local;
import javax.persistence.EntityExistsException;
import libros.entity.Book;


/**
 *
 * @author Jon Xabier Gimenez
 */
@Local
public interface GestorLibrosBeanLocal {
    
    public Collection getAllLibros() throws BusquedaLibroException;
    public void createLibro(Book create) throws CreateLibroException,EntityExistsException ;
    public void deleteLibro(Book delete) throws BorrarLibroException;
    public void updateLibro(Book update) throws ActualizarLibroException;
    public Collection busquedaPorISBN(String isbn) throws BusquedaLibroException;
    public Collection busquedaPorTitulo(String titulo) throws BusquedaLibroException;
    public Collection busquedaPorAutor(String autor) throws BusquedaLibroException;
    
}
