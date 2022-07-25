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
 * @author diego
 */
//Probando commit
@Entity
@Table(name = "habitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h")
    , @NamedQuery(name = "Habitaciones.findByHabCodigo", query = "SELECT h FROM Habitaciones h WHERE h.habCodigo = :habCodigo")
    , @NamedQuery(name = "Habitaciones.findByHabId", query = "SELECT h FROM Habitaciones h WHERE h.habId = :habId")
    //, @NamedQuery(name = "Habitaciones.findByHabHotelHabitaciones", query = "SELECT h FROM Habitaciones h WHERE h.habHotel = :hotel AND h.habId NOT IN (SELECT d.dregHabitacion FROM Detalleregistro d WHERE CAST(d.dregRegistro.regFechasalida AS DATE) < :fecha)")
    , @NamedQuery(name = "Habitaciones.findByHabHotelHabitaciones", query = "SELECT h FROM Habitaciones h WHERE h.habId NOT IN (SELECT d.dregHabitacion.habId FROM Detalleregistro d WHERE CAST(d.dregRegistro.regFechasalida AS DATE) < :fecha)")
    , @NamedQuery(name = "Habitaciones.findByHabDescripcion", query = "SELECT h FROM Habitaciones h WHERE h.habDescripcion = :habDescripcion")})
public class Habitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hab_codigo")
    private Integer habCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "hab_id")
    private String habId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hab_descripcion")
    private String habDescripcion;
    @JoinColumn(name = "hab_hotel", referencedColumnName = "hot_codigo")
    @ManyToOne(optional = false)
    private Hoteles habHotel;
    @JoinColumn(name = "hab_tipo", referencedColumnName = "tip_codigo")
    @ManyToOne(optional = false)
    private Tipohabitaciones habTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dregHabitacion")
    private Collection<Detalleregistro> detalleregistroCollection;

    public Habitaciones() {
    }

    public Habitaciones(Integer habCodigo) {
        this.habCodigo = habCodigo;
    }

    public Habitaciones(Integer habCodigo, String habId, String habDescripcion) {
        this.habCodigo = habCodigo;
        this.habId = habId;
        this.habDescripcion = habDescripcion;
    }

    public Integer getHabCodigo() {
        return habCodigo;
    }

    public void setHabCodigo(Integer habCodigo) {
        this.habCodigo = habCodigo;
    }

    public String getHabId() {
        return habId;
    }

    public void setHabId(String habId) {
        this.habId = habId;
    }

    public String getHabDescripcion() {
        return habDescripcion;
    }

    public void setHabDescripcion(String habDescripcion) {
        this.habDescripcion = habDescripcion;
    }

    public Hoteles getHabHotel() {
        return habHotel;
    }

    public void setHabHotel(Hoteles habHotel) {
        this.habHotel = habHotel;
    }

    public Tipohabitaciones getHabTipo() {
        return habTipo;
    }

    public void setHabTipo(Tipohabitaciones habTipo) {
        this.habTipo = habTipo;
    }

    @XmlTransient
    public Collection<Detalleregistro> getDetalleregistroCollection() {
        return detalleregistroCollection;
    }

    public void setDetalleregistroCollection(Collection<Detalleregistro> detalleregistroCollection) {
        this.detalleregistroCollection = detalleregistroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habCodigo != null ? habCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.habCodigo == null && other.habCodigo != null) || (this.habCodigo != null && !this.habCodigo.equals(other.habCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return habId;
    }
    
}
