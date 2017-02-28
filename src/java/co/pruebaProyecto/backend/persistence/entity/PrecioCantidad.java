/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.pruebaProyecto.backend.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandra
 */
@Entity
@Table(name = "precioscantidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioCantidad.findAll", query = "SELECT p FROM PrecioCantidad p")
    , @NamedQuery(name = "PrecioCantidad.findByIdPrecioCantidad", query = "SELECT p FROM PrecioCantidad p WHERE p.idPrecioCantidad = :idPrecioCantidad")
    , @NamedQuery(name = "PrecioCantidad.findByPeso", query = "SELECT p FROM PrecioCantidad p WHERE p.peso = :peso")
    , @NamedQuery(name = "PrecioCantidad.findByCosto", query = "SELECT p FROM PrecioCantidad p WHERE p.costo = :costo")})
public class PrecioCantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrecioCantidad")
    private Integer idPrecioCantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioCantidad", fetch = FetchType.EAGER)
    private List<Producto> productoList;

    public PrecioCantidad() {
    }

    public PrecioCantidad(Integer idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public PrecioCantidad(Integer idPrecioCantidad, String peso, int costo) {
        this.idPrecioCantidad = idPrecioCantidad;
        this.peso = peso;
        this.costo = costo;
    }

    public Integer getIdPrecioCantidad() {
        return idPrecioCantidad;
    }

    public void setIdPrecioCantidad(Integer idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecioCantidad != null ? idPrecioCantidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioCantidad)) {
            return false;
        }
        PrecioCantidad other = (PrecioCantidad) object;
        if ((this.idPrecioCantidad == null && other.idPrecioCantidad != null) || (this.idPrecioCantidad != null && !this.idPrecioCantidad.equals(other.idPrecioCantidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.PrecioCantidad[ idPrecioCantidad=" + idPrecioCantidad + " ]";
    }
    
}
