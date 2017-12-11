/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion in an Gender entity operation.
 * @author Jon Xabier Gimenez
 */
public class CreateGeneroException extends Exception {
        /**
     * Creates a new instance of <code>CreateGeneroException</code> without
     * detail message.
     */
    public CreateGeneroException() {
    }

    /**
     * Constructs an instance of <code>CreateGeneroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CreateGeneroException(String msg) {
        super(msg);
    }
}
