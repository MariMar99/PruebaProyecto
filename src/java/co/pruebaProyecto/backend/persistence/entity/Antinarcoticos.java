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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "antinarcoticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antinarcoticos.findAll", query = "SELECT a FROM Antinarcoticos a")
    , @NamedQuery(name = "Antinarcoticos.findByIdAntinarcoticos", query = "SELECT a FROM Antinarcoticos a WHERE a.idAntinarcoticos = :idAntinarcoticos")
    , @NamedQuery(name = "Antinarcoticos.findByNumerosPrecintos", query = "SELECT a FROM Antinarcoticos a WHERE a.numerosPrecintos = :numerosPrecintos")
    , @NamedQuery(name = "Antinarcoticos.findByAgenciaAduanas", query = "SELECT a FROM Antinarcoticos a WHERE a.agenciaAduanas = :agenciaAduanas")
    , @NamedQuery(name = "Antinarcoticos.findByAlcanceVuce", query = "SELECT a FROM Antinarcoticos a WHERE a.alcanceVuce = :alcanceVuce")})
public class Antinarcoticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAntinarcoticos")
    private Integer idAntinarcoticos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcionMercancia")
    private String descripcionMercancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numerosPrecintos")
    private String numerosPrecintos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agenciaAduanas")
    private int agenciaAduanas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "alcanceVuce")
    private String alcanceVuce;
    @JoinColumn(name = "idCiudadDestino", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ciudad idCiudadDestino;
    @JoinColumn(name = "idEstadoAnti", referencedColumnName = "idEstadoAntinarcoticos")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoAntinarcoticos idEstadoAnti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAntinarcoticos", fetch = FetchType.EAGER)
    private List<Pedido> pedidoList;

    public Antinarcoticos() {
    }

    public Antinarcoticos(Integer idAntinarcoticos) {
        this.idAntinarcoticos = idAntinarcoticos;
    }

    public Antinarcoticos(Integer idAntinarcoticos, String descripcionMercancia, String numerosPrecintos, int agenciaAduanas, String alcanceVuce) {
        this.idAntinarcoticos = idAntinarcoticos;
        this.descripcionMercancia = descripcionMercancia;
        this.numerosPrecintos = numerosPrecintos;
        this.agenciaAduanas = agenciaAduanas;
        this.alcanceVuce = alcanceVuce;
    }

    public Integer getIdAntinarcoticos() {
        return idAntinarcoticos;
    }

    public void setIdAntinarcoticos(Integer idAntinarcoticos) {
        this.idAntinarcoticos = idAntinarcoticos;
    }

    public String getDescripcionMercancia() {
        return descripcionMercancia;
    }

    public void setDescripcionMercancia(String descripcionMercancia) {
        this.descripcionMercancia = descripcionMercancia;
    }

    public String getNumerosPrecintos() {
        return numerosPrecintos;
    }

    public void setNumerosPrecintos(String numerosPrecintos) {
        this.numerosPrecintos = numerosPrecintos;
    }

    public int getAgenciaAduanas() {
        return agenciaAduanas;
    }

    public void setAgenciaAduanas(int agenciaAduanas) {
        this.agenciaAduanas = agenciaAduanas;
    }

    public String getAlcanceVuce() {
        return alcanceVuce;
    }

    public void setAlcanceVuce(String alcanceVuce) {
        this.alcanceVuce = alcanceVuce;
    }

    public Ciudad getIdCiudadDestino() {
        return idCiudadDestino;
    }

    public void setIdCiudadDestino(Ciudad idCiudadDestino) {
        this.idCiudadDestino = idCiudadDestino;
    }

    public EstadoAntinarcoticos getIdEstadoAnti() {
        return idEstadoAnti;
    }

    public void setIdEstadoAnti(EstadoAntinarcoticos idEstadoAnti) {
        this.idEstadoAnti = idEstadoAnti;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntinarcoticos != null ? idAntinarcoticos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antinarcoticos)) {
            return false;
        }
        Antinarcoticos other = (Antinarcoticos) object;
        if ((this.idAntinarcoticos == null && other.idAntinarcoticos != null) || (this.idAntinarcoticos != null && !this.idAntinarcoticos.equals(other.idAntinarcoticos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.Antinarcoticos[ idAntinarcoticos=" + idAntinarcoticos + " ]";
    }
    
}
