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
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCliCodigo", query = "SELECT c FROM Clientes c WHERE c.cliCodigo = :cliCodigo")
    , @NamedQuery(name = "Clientes.findByCliTipo", query = "SELECT c FROM Clientes c WHERE c.cliTipo = :cliTipo")
    , @NamedQuery(name = "Clientes.findByCliId", query = "SELECT c FROM Clientes c WHERE c.cliId = :cliId")
    , @NamedQuery(name = "Clientes.findByCliNombre", query = "SELECT c FROM Clientes c WHERE c.cliNombre = :cliNombre")
    , @NamedQuery(name = "Clientes.findByCliDireccion", query = "SELECT c FROM Clientes c WHERE c.cliDireccion = :cliDireccion")
    , @NamedQuery(name = "Clientes.findByCliCelular", query = "SELECT c FROM Clientes c WHERE c.cliCelular = :cliCelular")
    , @NamedQuery(name = "Clientes.findByCliTelefono", query = "SELECT c FROM Clientes c WHERE c.cliTelefono = :cliTelefono")
    , @NamedQuery(name = "Clientes.findByCliCorreo", query = "SELECT c FROM Clientes c WHERE c.cliCorreo = :cliCorreo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cli_tipo")
    private String cliTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cli_id")
    private String cliId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cli_celular")
    private String cliCelular;
    @Size(max = 10)
    @Column(name = "cli_telefono")
    private String cliTelefono;
    @Size(max = 100)
    @Column(name = "cli_correo")
    private String cliCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regCliente")
    private Collection<Registros> registrosCollection;
    @JoinColumn(name = "cli_hotel", referencedColumnName = "hot_codigo")
    @ManyToOne(optional = false)
    private Hoteles cliHotel;

    public Clientes() {
    }

    public Clientes(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Clientes(Integer cliCodigo, String cliTipo, String cliId, String cliNombre, String cliDireccion, String cliCelular) {
        this.cliCodigo = cliCodigo;
        this.cliTipo = cliTipo;
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliDireccion = cliDireccion;
        this.cliCelular = cliCelular;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        this.cliTipo = cliTipo;
    }

    public String getCliId() {
        return cliId;
    }

    public void setCliId(String cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    @XmlTransient
    public Collection<Registros> getRegistrosCollection() {
        return registrosCollection;
    }

    public void setRegistrosCollection(Collection<Registros> registrosCollection) {
        this.registrosCollection = registrosCollection;
    }

    public Hoteles getCliHotel() {
        return cliHotel;
    }

    public void setCliHotel(Hoteles cliHotel) {
        this.cliHotel = cliHotel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cliNombre;
    }
    
}
