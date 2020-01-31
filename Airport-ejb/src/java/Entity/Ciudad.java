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
@Table(name = "Ciudad")
@NamedQueries({
@NamedQuery(name = "findCiudad", query = "SELECT c FROM Ciudad c"),
@NamedQuery(name = "findIDNQC", query = "SELECT c FROM Ciudad c WHERE c.id=:id"),
@NamedQuery(name = "findPaisC", query = "SELECT c FROM Ciudad c WHERE c.Estado.Pais.Nombre=:pais")
})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 35, nullable = false)
    private String Nombre;

    @JoinColumn(name = "Estado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado Estado;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Origen")
    private List<Vuelo> origenList;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Destino")
    private List<Vuelo> destinoList;

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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ciudad[ id=" + id + " ]" + "Nombre: " + getNombre() + "Estado: " + getEstado().getNombre();
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
     * @return the Estado
     */
    public Estado getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }

}
