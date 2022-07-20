package com.gestionhoteles.entidades;

import com.gestionhoteles.entidades.Habitaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-19T10:42:11")
@StaticMetamodel(Tipohabitaciones.class)
public class Tipohabitaciones_ { 

    public static volatile CollectionAttribute<Tipohabitaciones, Habitaciones> habitacionesCollection;
    public static volatile SingularAttribute<Tipohabitaciones, String> tipId;
    public static volatile SingularAttribute<Tipohabitaciones, Integer> tipCodigo;
    public static volatile SingularAttribute<Tipohabitaciones, String> tipDescripcion;

}