package com.gestionhoteles.entidades;

import com.gestionhoteles.entidades.Clientes;
import com.gestionhoteles.entidades.Habitaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-19T10:42:11")
@StaticMetamodel(Hoteles.class)
public class Hoteles_ { 

    public static volatile CollectionAttribute<Hoteles, Habitaciones> habitacionesCollection;
    public static volatile SingularAttribute<Hoteles, Integer> hotCodigo;
    public static volatile SingularAttribute<Hoteles, String> hotId;
    public static volatile SingularAttribute<Hoteles, String> hotDireccion;
    public static volatile CollectionAttribute<Hoteles, Clientes> clientesCollection;
    public static volatile SingularAttribute<Hoteles, String> hotNombre;

}