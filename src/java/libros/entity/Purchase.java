/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
  *Entity class to store our purchases. 
 * <ul>
  * <li><strong>codigo:</strong> Autonumeric Integer to identify the purchase.</li>
  * <li><strong>usuario:</strong> {@link User} that purchases . </li>
  * <li><strong>fechaCompra:</strong> Date of the purchase. </li>
  * <li><strong>precioTotal:</strong> Total price. </li>
  * <li><strong>ejemplares:</strong> Collection of {@link Book}s of the purchase </li>
  * </ul>
 * @author Discos S.L Corporation
 */
@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @ManyToOne
    private User usuario;
    private Date fechaCompra;
    private Float precioTotal;
    @ManyToMany
    private Collection<Book> ejemplares;
    //paco

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Purchase[ codigo=" + codigo + " ]";
    }
    
}
