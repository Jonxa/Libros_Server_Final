/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *Entidad que se ocupa de almacenar todos los datos de los administradores de la aplicación
 * @author Discos S.L Corporation
 */
@Entity
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String admin;
    private String password;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admin != null ? admin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.admin == null && other.admin != null) || (this.admin != null && !this.admin.equals(other.admin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Admin[ admin=" + admin + " ]";
    }
    
}
