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
@Table(name = "empresastransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaTransporte.findAll", query = "SELECT e FROM EmpresaTransporte e")
    , @NamedQuery(name = "EmpresaTransporte.findByIdEmpresaTransporte", query = "SELECT e FROM EmpresaTransporte e WHERE e.idEmpresaTransporte = :idEmpresaTransporte")
    , @NamedQuery(name = "EmpresaTransporte.findByNombreEmpresa", query = "SELECT e FROM EmpresaTransporte e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "EmpresaTransporte.findByTelefono", query = "SELECT e FROM EmpresaTransporte e WHERE e.telefono = :telefono")})
public class EmpresaTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresaTransporte")
    private Integer idEmpresaTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ciudad idCiudad;
    @JoinColumn(name = "idTipoTransporte", referencedColumnName = "idTipoTransporte")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoTransporte idTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaTransporte", fetch = FetchType.EAGER)
    private List<Transporte> transporteList;

    public EmpresaTransporte() {
    }

    public EmpresaTransporte(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public EmpresaTransporte(Integer idEmpresaTransporte, String nombreEmpresa, int telefono) {
        this.idEmpresaTransporte = idEmpresaTransporte;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
    }

    public Integer getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    public void setIdEmpresaTransporte(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public TipoTransporte getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(TipoTransporte idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    @XmlTransient
    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaTransporte != null ? idEmpresaTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaTransporte)) {
            return false;
        }
        EmpresaTransporte other = (EmpresaTransporte) object;
        if ((this.idEmpresaTransporte == null && other.idEmpresaTransporte != null) || (this.idEmpresaTransporte != null && !this.idEmpresaTransporte.equals(other.idEmpresaTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.EmpresaTransporte[ idEmpresaTransporte=" + idEmpresaTransporte + " ]";
    }
    
}
