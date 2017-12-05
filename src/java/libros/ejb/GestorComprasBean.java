/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author Iker Iglesias
 */
@Stateless
public class GestorComprasBean implements GestorComprasBeanLocal {

    /**
     *
     * @return
     */
    @Override
    public Collection getAllCompras(){
        
        return null;
    }

    @Override
    public void createCompra() {
    }

    @Override
    public void deleteCompra() {
    }

    @Override
    public void updateCompra() {
    }
    
    
}
