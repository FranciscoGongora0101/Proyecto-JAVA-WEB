/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josefrancisco
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Nombre", length = 50, nullable = false)
    private String Nombre;
    
    @Column(name = "Email", length = 60, nullable = false)
    private String Email;
    
    @Column(name = "Contrasena", length = 30, nullable = false)
    private String Contasena;
    
    @Column(name = "Perfil", nullable = false)
    private int Perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Usuario[ id=" + id + " ]";
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Contasena
     */
    public String getContasena() {
        return Contasena;
    }

    /**
     * @param Contasena the Contasena to set
     */
    public void setContasena(String Contasena) {
        this.Contasena = Contasena;
    }

    /**
     * @return the Perfil
     */
    public int getPerfil() {
        return Perfil;
    }

    /**
     * @param Perfil the Perfil to set
     */
    public void setPerfil(int Perfil) {
        this.Perfil = Perfil;
    }
    
    
}
