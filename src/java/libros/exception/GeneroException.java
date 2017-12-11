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
public class GeneroException extends Exception {
        /**
     * Creates a new instance of <code>GeneroException</code> without
     * detail message.
     */
    public GeneroException() {
    }

    /**
     * Constructs an instance of <code>GeneroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GeneroException(String msg) {
        super(msg);
    }
}
