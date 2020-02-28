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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josefrancisco
 */
@Entity
@Table(name = "Avion")
@NamedQueries({
@NamedQuery(name = "findAvion", query = "SELECT c FROM Avion c"),
@NamedQuery(name = "findIDnq", query = "SELECT c FROM Avion c WHERE c.id=:id"),
@NamedQuery(name = "findAvionyPasajeros", query = "SELECT c FROM Avion c WHERE c.Numero_Avion=:num AND c.Cantidad_Pasajeros=:pas")
})
public class Avion implements Serializable {

    /**
     * @return the avionList
     */
    public List<Vuelo> getAvionList() {
        return avionList;
    }

    /**
     * @param avionList the avionList to set
     */
    public void setAvionList(List<Vuelo> avionList) {
        this.avionList = avionList;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero_Avion", length = 20, nullable = false)
    private String Numero_Avion;

    @Column(name = "Pasajeros", nullable = false)
    private int Cantidad_Pasajeros;

    @Column(name = "Modelo", length = 25, nullable = false)
    private String Modelo;

    @Column(name = "Aerolinea", length = 35, nullable = false)
    private String Aerolinea;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Avion")
    private List<Vuelo> avionList;

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
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + id + ", Numero de Avion: " + getNumero_Avion() + ", Cantidad de Pasajeros: " + getCantidad_Pasajeros() + "]";
    }

    /**
     * @return the Numero_Avion
     */
    public String getNumero_Avion() {
        return Numero_Avion;
    }

    /**
     * @param Numero_Avion the Numero_Avion to set
     */
    public void setNumero_Avion(String Numero_Avion) {
        this.Numero_Avion = Numero_Avion;
    }

    /**
     * @return the Cantidad_Pasajeros
     */
    public int getCantidad_Pasajeros() {
        return Cantidad_Pasajeros;
    }

    /**
     * @param Cantidad_Pasajeros the Cantidad_Pasajeros to set
     */
    public void setCantidad_Pasajeros(int Cantidad_Pasajeros) {
        this.Cantidad_Pasajeros = Cantidad_Pasajeros;
    }

    /**
     * @return the Modelo
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * @param Modelo the Modelo to set
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * @return the Aerolinea
     */
    public String getAerolinea() {
        return Aerolinea;
    }

    /**
     * @param Aerolinea the Aerolinea to set
     */
    public void setAerolinea(String Aerolinea) {
        this.Aerolinea = Aerolinea;
    }

}
