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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCiudad")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreCiudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadDestino", fetch = FetchType.EAGER)
    private List<Antinarcoticos> antinarcoticosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;
    @JoinColumn(name = "idPais", referencedColumnName = "idPais")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pais idPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private List<Trazabilidad> trazabilidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private List<EmpresaTransporte> empresaTransporteList;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Integer idCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<Antinarcoticos> getAntinarcoticosList() {
        return antinarcoticosList;
    }

    public void setAntinarcoticosList(List<Antinarcoticos> antinarcoticosList) {
        this.antinarcoticosList = antinarcoticosList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public List<Trazabilidad> getTrazabilidadList() {
        return trazabilidadList;
    }

    public void setTrazabilidadList(List<Trazabilidad> trazabilidadList) {
        this.trazabilidadList = trazabilidadList;
    }

    @XmlTransient
    public List<EmpresaTransporte> getEmpresaTransporteList() {
        return empresaTransporteList;
    }

    public void setEmpresaTransporteList(List<EmpresaTransporte> empresaTransporteList) {
        this.empresaTransporteList = empresaTransporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
