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
@Table(name = "tipostransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransporte.findAll", query = "SELECT t FROM TipoTransporte t")
    , @NamedQuery(name = "TipoTransporte.findByIdTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.idTipoTransporte = :idTipoTransporte")
    , @NamedQuery(name = "TipoTransporte.findByNombreTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.nombreTipoTransporte = :nombreTipoTransporte")})
public class TipoTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTransporte")
    private Integer idTipoTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreTipoTransporte")
    private String nombreTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransporte", fetch = FetchType.EAGER)
    private List<EmpresaTransporte> empresaTransporteList;

    public TipoTransporte() {
    }

    public TipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public TipoTransporte(Integer idTipoTransporte, String nombreTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    public Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getNombreTipoTransporte() {
        return nombreTipoTransporte;
    }

    public void setNombreTipoTransporte(String nombreTipoTransporte) {
        this.nombreTipoTransporte = nombreTipoTransporte;
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
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransporte)) {
            return false;
        }
        TipoTransporte other = (TipoTransporte) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.TipoTransporte[ idTipoTransporte=" + idTipoTransporte + " ]";
    }
    
}
