/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import exception.CreateGeneroException;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author 2dam
 */
@Stateless
public class GestorGenerosBean implements GestorGenerosBeanLocal {

    @Override
    public Collection getAllGeneros() {
        return null;
    }

    @Override
    public void createGenero() throws CreateGeneroException {
    }

    @Override
    public void deleteGenero() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
