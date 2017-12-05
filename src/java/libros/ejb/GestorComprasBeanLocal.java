/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import javax.ejb.Local;
import libros.exception.CreateCompraException;

/**
 *
 * @author Iker Iglesias
 */
@Local
public interface GestorComprasBeanLocal {

    public Collection getAllCompras();
    public void createCompra() throws CreateCompraException;
    public void deleteCompra();
    public void updateCompra();
    
}
