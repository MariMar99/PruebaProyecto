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
@Table(name = "tiposempaques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmpaque.findAll", query = "SELECT t FROM TipoEmpaque t")
    , @NamedQuery(name = "TipoEmpaque.findByIdTipoEmpaque", query = "SELECT t FROM TipoEmpaque t WHERE t.idTipoEmpaque = :idTipoEmpaque")
    , @NamedQuery(name = "TipoEmpaque.findByMarcaCaja", query = "SELECT t FROM TipoEmpaque t WHERE t.marcaCaja = :marcaCaja")})
public class TipoEmpaque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoEmpaque")
    private Integer idTipoEmpaque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marcaCaja")
    private String marcaCaja;
    @JoinColumn(name = "idMedidaCaja", referencedColumnName = "idMedidaCaja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MedidaCaja idMedidaCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpaque", fetch = FetchType.EAGER)
    private List<DetallePedido> detallePedidoList;

    public TipoEmpaque() {
    }

    public TipoEmpaque(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public TipoEmpaque(Integer idTipoEmpaque, String marcaCaja) {
        this.idTipoEmpaque = idTipoEmpaque;
        this.marcaCaja = marcaCaja;
    }

    public Integer getIdTipoEmpaque() {
        return idTipoEmpaque;
    }

    public void setIdTipoEmpaque(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public String getMarcaCaja() {
        return marcaCaja;
    }

    public void setMarcaCaja(String marcaCaja) {
        this.marcaCaja = marcaCaja;
    }

    public MedidaCaja getIdMedidaCaja() {
        return idMedidaCaja;
    }

    public void setIdMedidaCaja(MedidaCaja idMedidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEmpaque != null ? idTipoEmpaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpaque)) {
            return false;
        }
        TipoEmpaque other = (TipoEmpaque) object;
        if ((this.idTipoEmpaque == null && other.idTipoEmpaque != null) || (this.idTipoEmpaque != null && !this.idTipoEmpaque.equals(other.idTipoEmpaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.TipoEmpaque[ idTipoEmpaque=" + idTipoEmpaque + " ]";
    }
    
}
