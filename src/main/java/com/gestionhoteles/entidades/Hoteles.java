/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionhoteles.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "hoteles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoteles.findAll", query = "SELECT h FROM Hoteles h")
    , @NamedQuery(name = "Hoteles.findByHotCodigo", query = "SELECT h FROM Hoteles h WHERE h.hotCodigo = :hotCodigo")
    , @NamedQuery(name = "Hoteles.findByHotId", query = "SELECT h FROM Hoteles h WHERE h.hotId = :hotId")
    , @NamedQuery(name = "Hoteles.findByHotNombre", query = "SELECT h FROM Hoteles h WHERE h.hotNombre = :hotNombre")
    , @NamedQuery(name = "Hoteles.findByHotDireccion", query = "SELECT h FROM Hoteles h WHERE h.hotDireccion = :hotDireccion")})
public class Hoteles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hot_codigo")
    private Integer hotCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "hot_id")
    private String hotId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hot_nombre")
    private String hotNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hot_direccion")
    private String hotDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habHotel")
    private Collection<Habitaciones> habitacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliHotel")
    private Collection<Clientes> clientesCollection;

    public Hoteles() {
    }

    public Hoteles(Integer hotCodigo) {
        this.hotCodigo = hotCodigo;
    }

    public Hoteles(Integer hotCodigo, String hotId, String hotNombre, String hotDireccion) {
        this.hotCodigo = hotCodigo;
        this.hotId = hotId;
        this.hotNombre = hotNombre;
        this.hotDireccion = hotDireccion;
    }

    public Integer getHotCodigo() {
        return hotCodigo;
    }

    public void setHotCodigo(Integer hotCodigo) {
        this.hotCodigo = hotCodigo;
    }

    public String getHotId() {
        return hotId;
    }

    public void setHotId(String hotId) {
        this.hotId = hotId;
    }

    public String getHotNombre() {
        return hotNombre;
    }

    public void setHotNombre(String hotNombre) {
        this.hotNombre = hotNombre;
    }

    public String getHotDireccion() {
        return hotDireccion;
    }

    public void setHotDireccion(String hotDireccion) {
        this.hotDireccion = hotDireccion;
    }

    @XmlTransient
    public Collection<Habitaciones> getHabitacionesCollection() {
        return habitacionesCollection;
    }

    public void setHabitacionesCollection(Collection<Habitaciones> habitacionesCollection) {
        this.habitacionesCollection = habitacionesCollection;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotCodigo != null ? hotCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoteles)) {
            return false;
        }
        Hoteles other = (Hoteles) object;
        if ((this.hotCodigo == null && other.hotCodigo != null) || (this.hotCodigo != null && !this.hotCodigo.equals(other.hotCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return hotNombre;
    }
    
}
