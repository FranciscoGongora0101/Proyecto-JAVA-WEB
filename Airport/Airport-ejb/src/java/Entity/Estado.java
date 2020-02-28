/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josefrancisco
 */
@Entity
@Table(name = "Estado")
@NamedQueries({
@NamedQuery(name = "findEstado", query = "SELECT c FROM Estado c"),
@NamedQuery(name = "findIDNQE", query = "SELECT c FROM Estado c WHERE c.id=:id")
})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 35, nullable = false)
    private String Nombre;

    @JoinColumn(name = "Pais", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pais Pais;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Estado")
    private List<Ciudad> estadoList;

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
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Estado[ id=" + id + " ]" + "Nombre: " + getNombre() + "Pais: " + getPais().getNombre();
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
     * @return the Pais
     */
    public Pais getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }

    /**
     * @return the estadoList
     */
    public List<Ciudad> getEstadoList() {
        return estadoList;
    }

    /**
     * @param estadoList the estadoList to set
     */
    public void setEstadoList(List<Ciudad> estadoList) {
        this.estadoList = estadoList;
    }
    
    

}
