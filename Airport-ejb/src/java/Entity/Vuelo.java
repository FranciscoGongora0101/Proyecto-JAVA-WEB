/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author josefrancisco
 */
@Entity
@Table(name = "Vuelo")
@NamedQueries({
@NamedQuery(name = "findVuelo", query = "SELECT c FROM Vuelo c"),
@NamedQuery(name = "findIDNQV", query = "SELECT c FROM Vuelo c WHERE c.id=:id")
})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero_Vuelo", length = 20, nullable = false)
    private String Numero_Vuelo;

    @JoinColumn(name = "Avion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Avion Avion;



    @JoinColumn(name = "Origen", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad Origen;


    @JoinColumn(name = "Destino", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad Destino;
    
    
    @Column(name = "Numero_pasajeros", nullable = false)
    private int Numero_Pasajeros;

    @Column(name = "Fecha_Inicio_Vuelo", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Inicio;

    @Column(name = "Fecha_Final_Vuelo", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Final_Vuelo;

    @Column(name = "Hora_Inicio_Vuelo", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date Hora_Inicio_Vuelo;

    @Column(name = "Hora_Final_Vuelo", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date Hora_Final_Vuelo;

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
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Vuelo[ id=" + id + " ]" + "Numero de Vuelo: " + getNumero_Vuelo() + "Numero de Avion: " + getAvion().getNumero_Avion() + "Origen: " + getOrigen().getNombre() + "Destino:" + getDestino().getNombre();
    }

    /**
     * @return the Numero_Vuelo
     */
    public String getNumero_Vuelo() {
        return Numero_Vuelo;
    }

    /**
     * @param Numero_Vuelo the Numero_Vuelo to set
     */
    public void setNumero_Vuelo(String Numero_Vuelo) {
        this.Numero_Vuelo = Numero_Vuelo;
    }


    /**
     * @return the Numero_Pasajeros
     */
    public int getNumero_Pasajeros() {
        return Numero_Pasajeros;
    }

    /**
     * @param Numero_Pasajeros the Numero_Pasajeros to set
     */
    public void setNumero_Pasajeros(int Numero_Pasajeros) {
        this.Numero_Pasajeros = Numero_Pasajeros;
    }

    /**
     * @return the Fecha_Inicio
     */
    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    /**
     * @param Fecha_Inicio the Fecha_Inicio to set
     */
    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    /**
     * @return the Fecha_Final_Vuelo
     */
    public Date getFecha_Final_Vuelo() {
        return Fecha_Final_Vuelo;
    }

    /**
     * @param Fecha_Final_Vuelo the Fecha_Final_Vuelo to set
     */
    public void setFecha_Final_Vuelo(Date Fecha_Final_Vuelo) {
        this.Fecha_Final_Vuelo = Fecha_Final_Vuelo;
    }

    /**
     * @return the Hora_Inicio_Vuelo
     */
    public Date getHora_Inicio_Vuelo() {
        return Hora_Inicio_Vuelo;
    }

    /**
     * @param Hora_Inicio_Vuelo the Hora_Inicio_Vuelo to set
     */
    public void setHora_Inicio_Vuelo(Date Hora_Inicio_Vuelo) {
        this.Hora_Inicio_Vuelo = Hora_Inicio_Vuelo;
    }

    /**
     * @return the Hora_Final_Vuelo
     */
    public Date getHora_Final_Vuelo() {
        return Hora_Final_Vuelo;
    }

    /**
     * @param Hora_Final_Vuelo the Hora_Final_Vuelo to set
     */
    public void setHora_Final_Vuelo(Date Hora_Final_Vuelo) {
        this.Hora_Final_Vuelo = Hora_Final_Vuelo;
    }

    /**
     * @return the Avion
     */
    public Avion getAvion() {
        return Avion;
    }

    /**
     * @param Avion the Avion to set
     */
    public void setAvion(Avion Avion) {
        this.Avion = Avion;
    }

    /**
     * @return the Origen
     */
    public Ciudad getOrigen() {
        return Origen;
    }

    /**
     * @param Origen the Origen to set
     */
    public void setOrigen(Ciudad Origen) {
        this.Origen = Origen;
    }

    /**
     * @return the Destino
     */
    public Ciudad getDestino() {
        return Destino;
    }

    /**
     * @param Destino the Destino to set
     */
    public void setDestino(Ciudad Destino) {
        this.Destino = Destino;
    }
    
    

}
