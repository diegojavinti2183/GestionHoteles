package com.gestionhoteles.entidades;

import com.gestionhoteles.entidades.Detalleregistro;
import com.gestionhoteles.entidades.Hoteles;
import com.gestionhoteles.entidades.Tipohabitaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-23T08:31:15")
@StaticMetamodel(Habitaciones.class)
public class Habitaciones_ { 

    public static volatile SingularAttribute<Habitaciones, Integer> habCodigo;
    public static volatile SingularAttribute<Habitaciones, String> habId;
    public static volatile CollectionAttribute<Habitaciones, Detalleregistro> detalleregistroCollection;
    public static volatile SingularAttribute<Habitaciones, Hoteles> habHotel;
    public static volatile SingularAttribute<Habitaciones, Tipohabitaciones> habTipo;
    public static volatile SingularAttribute<Habitaciones, String> habDescripcion;

}