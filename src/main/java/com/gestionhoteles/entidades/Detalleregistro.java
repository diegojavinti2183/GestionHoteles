/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionhoteles.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "detalleregistro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleregistro.findAll", query = "SELECT d FROM Detalleregistro d")
    , @NamedQuery(name = "Detalleregistro.findByDregCodigo", query = "SELECT d FROM Detalleregistro d WHERE d.dregCodigo = :dregCodigo")
        , @NamedQuery(name = "Detalleregistro.findByDregNoOcupadas", query = "SELECT d.dregHabitacion FROM Detalleregistro d WHERE d.dregCodigo = :dregCodigo")
    , @NamedQuery(name = "Detalleregistro.findByDregObservacion", query = "SELECT d FROM Detalleregistro d WHERE d.dregObservacion = :dregObservacion")})
public class Detalleregistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dreg_codigo")
    private Integer dregCodigo;
    @Size(max = 200)
    @Column(name = "dreg_observacion")
    private String dregObservacion;
    @JoinColumn(name = "dreg_habitacion", referencedColumnName = "hab_codigo")
    @ManyToOne(optional = false)
    private Habitaciones dregHabitacion;
    @JoinColumn(name = "dreg_registro", referencedColumnName = "reg_numero")
    @ManyToOne(optional = false)
    private Registros dregRegistro;

    public Detalleregistro() {
    }

    public Detalleregistro(Integer dregCodigo) {
        this.dregCodigo = dregCodigo;
    }

    public Integer getDregCodigo() {
        return dregCodigo;
    }

    public void setDregCodigo(Integer dregCodigo) {
        this.dregCodigo = dregCodigo;
    }

    public String getDregObservacion() {
        return dregObservacion;
    }

    public void setDregObservacion(String dregObservacion) {
        this.dregObservacion = dregObservacion;
    }

    public Habitaciones getDregHabitacion() {
        return dregHabitacion;
    }

    public void setDregHabitacion(Habitaciones dregHabitacion) {
        this.dregHabitacion = dregHabitacion;
    }

    public Registros getDregRegistro() {
        return dregRegistro;
    }

    public void setDregRegistro(Registros dregRegistro) {
        this.dregRegistro = dregRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dregCodigo != null ? dregCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleregistro)) {
            return false;
        }
        Detalleregistro other = (Detalleregistro) object;
        if ((this.dregCodigo == null && other.dregCodigo != null) || (this.dregCodigo != null && !this.dregCodigo.equals(other.dregCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionhoteles.entidades.Detalleregistro[ dregCodigo=" + dregCodigo + " ]";
    }
    
}
