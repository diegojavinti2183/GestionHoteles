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
@Table(name = "tipohabitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipohabitaciones.findAll", query = "SELECT t FROM Tipohabitaciones t")
    , @NamedQuery(name = "Tipohabitaciones.findByTipCodigo", query = "SELECT t FROM Tipohabitaciones t WHERE t.tipCodigo = :tipCodigo")
    , @NamedQuery(name = "Tipohabitaciones.findByTipId", query = "SELECT t FROM Tipohabitaciones t WHERE t.tipId = :tipId")
    , @NamedQuery(name = "Tipohabitaciones.findByTipDescripcion", query = "SELECT t FROM Tipohabitaciones t WHERE t.tipDescripcion = :tipDescripcion")})
public class Tipohabitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tip_codigo")
    private Integer tipCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tip_id")
    private String tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tip_descripcion")
    private String tipDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habTipo")
    private Collection<Habitaciones> habitacionesCollection;

    public Tipohabitaciones() {
    }

    public Tipohabitaciones(Integer tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public Tipohabitaciones(Integer tipCodigo, String tipId, String tipDescripcion) {
        this.tipCodigo = tipCodigo;
        this.tipId = tipId;
        this.tipDescripcion = tipDescripcion;
    }

    public Integer getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(Integer tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipId() {
        return tipId;
    }

    public void setTipId(String tipId) {
        this.tipId = tipId;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }

    @XmlTransient
    public Collection<Habitaciones> getHabitacionesCollection() {
        return habitacionesCollection;
    }

    public void setHabitacionesCollection(Collection<Habitaciones> habitacionesCollection) {
        this.habitacionesCollection = habitacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipohabitaciones)) {
            return false;
        }
        Tipohabitaciones other = (Tipohabitaciones) object;
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipId;
    }
    
}
