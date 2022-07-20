/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionhoteles.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "registros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registros.findAll", query = "SELECT r FROM Registros r")
    , @NamedQuery(name = "Registros.findByRegNumero", query = "SELECT r FROM Registros r WHERE r.regNumero = :regNumero")
    , @NamedQuery(name = "Registros.findByRegFecha", query = "SELECT r FROM Registros r WHERE r.regFecha = :regFecha")
    , @NamedQuery(name = "Registros.findByRegFechainicio", query = "SELECT r FROM Registros r WHERE r.regFechainicio = :regFechainicio")
    , @NamedQuery(name = "Registros.findByRegFechasalida", query = "SELECT r FROM Registros r WHERE r.regFechasalida = :regFechasalida")
    , @NamedQuery(name = "Registros.findByRegObservacion", query = "SELECT r FROM Registros r WHERE r.regObservacion = :regObservacion")
    , @NamedQuery(name = "Registros.findByRegUsuarioing", query = "SELECT r FROM Registros r WHERE r.regUsuarioing = :regUsuarioing")
    , @NamedQuery(name = "Registros.findByRegFechaing", query = "SELECT r FROM Registros r WHERE r.regFechaing = :regFechaing")
    , @NamedQuery(name = "Registros.findByRegUsuariomod", query = "SELECT r FROM Registros r WHERE r.regUsuariomod = :regUsuariomod")
    , @NamedQuery(name = "Registros.findByRegFechamod", query = "SELECT r FROM Registros r WHERE r.regFechamod = :regFechamod")})
public class Registros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reg_numero")
    private Integer regNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_fecha")
    @Temporal(TemporalType.DATE)
    private Date regFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regFechainicio;
    @Column(name = "reg_fechasalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regFechasalida;
    @Size(max = 200)
    @Column(name = "reg_observacion")
    private String regObservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reg_usuarioing")
    private String regUsuarioing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_fechaing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regFechaing;
    @Size(max = 100)
    @Column(name = "reg_usuariomod")
    private String regUsuariomod;
    @Column(name = "reg_fechamod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regFechamod;
    @JoinColumn(name = "reg_cliente", referencedColumnName = "cli_codigo")
    @ManyToOne(optional = false)
    private Clientes regCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dregRegistro")
    private Collection<Detalleregistro> detalleregistroCollection;

    public Registros() {
    }

    public Registros(Integer regNumero) {
        this.regNumero = regNumero;
    }

    public Registros(Integer regNumero, Date regFecha, Date regFechainicio, String regUsuarioing, Date regFechaing) {
        this.regNumero = regNumero;
        this.regFecha = regFecha;
        this.regFechainicio = regFechainicio;
        this.regUsuarioing = regUsuarioing;
        this.regFechaing = regFechaing;
    }

    public Integer getRegNumero() {
        return regNumero;
    }

    public void setRegNumero(Integer regNumero) {
        this.regNumero = regNumero;
    }

    public Date getRegFecha() {
        return regFecha;
    }

    public void setRegFecha(Date regFecha) {
        this.regFecha = regFecha;
    }

    public Date getRegFechainicio() {
        return regFechainicio;
    }

    public void setRegFechainicio(Date regFechainicio) {
        this.regFechainicio = regFechainicio;
    }

    public Date getRegFechasalida() {
        return regFechasalida;
    }

    public void setRegFechasalida(Date regFechasalida) {
        this.regFechasalida = regFechasalida;
    }

    public String getRegObservacion() {
        return regObservacion;
    }

    public void setRegObservacion(String regObservacion) {
        this.regObservacion = regObservacion;
    }

    public String getRegUsuarioing() {
        return regUsuarioing;
    }

    public void setRegUsuarioing(String regUsuarioing) {
        this.regUsuarioing = regUsuarioing;
    }

    public Date getRegFechaing() {
        return regFechaing;
    }

    public void setRegFechaing(Date regFechaing) {
        this.regFechaing = regFechaing;
    }

    public String getRegUsuariomod() {
        return regUsuariomod;
    }

    public void setRegUsuariomod(String regUsuariomod) {
        this.regUsuariomod = regUsuariomod;
    }

    public Date getRegFechamod() {
        return regFechamod;
    }

    public void setRegFechamod(Date regFechamod) {
        this.regFechamod = regFechamod;
    }

    public Clientes getRegCliente() {
        return regCliente;
    }

    public void setRegCliente(Clientes regCliente) {
        this.regCliente = regCliente;
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
        hash += (regNumero != null ? regNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registros)) {
            return false;
        }
        Registros other = (Registros) object;
        if ((this.regNumero == null && other.regNumero != null) || (this.regNumero != null && !this.regNumero.equals(other.regNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionhoteles.entidades.Registros[ regNumero=" + regNumero + " ]";
    }
    
}
