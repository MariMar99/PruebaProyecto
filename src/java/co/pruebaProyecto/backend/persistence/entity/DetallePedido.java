/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.pruebaProyecto.backend.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandra
 */
@Entity
@Table(name = "detallespedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByIdDetallePedido", query = "SELECT d FROM DetallePedido d WHERE d.idDetallePedido = :idDetallePedido")
    , @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallePedido.findByMoneda", query = "SELECT d FROM DetallePedido d WHERE d.moneda = :moneda")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetallePedido")
    private Integer idDetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "moneda")
    private String moneda;
    @JoinColumn(name = "idPallet", referencedColumnName = "idPallet")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pallet idPallet;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido idPedido;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto idProducto;
    @JoinColumn(name = "idTipoEmpaque", referencedColumnName = "idTipoEmpaque")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEmpaque idTipoEmpaque;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public DetallePedido(Integer idDetallePedido, int cantidad, String moneda) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Pallet getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Pallet idPallet) {
        this.idPallet = idPallet;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public TipoEmpaque getIdTipoEmpaque() {
        return idTipoEmpaque;
    }

    public void setIdTipoEmpaque(TipoEmpaque idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePedido != null ? idDetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.idDetallePedido == null && other.idDetallePedido != null) || (this.idDetallePedido != null && !this.idDetallePedido.equals(other.idDetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.pruebaProyecto.backend.persistence.entity.DetallePedido[ idDetallePedido=" + idDetallePedido + " ]";
    }
    
}
