package com.gestionhoteles.entidades;

import com.gestionhoteles.entidades.Hoteles;
import com.gestionhoteles.entidades.Registros;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-19T10:42:11")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile CollectionAttribute<Clientes, Registros> registrosCollection;
    public static volatile SingularAttribute<Clientes, String> cliNombre;
    public static volatile SingularAttribute<Clientes, String> cliTelefono;
    public static volatile SingularAttribute<Clientes, String> cliCelular;
    public static volatile SingularAttribute<Clientes, String> cliTipo;
    public static volatile SingularAttribute<Clientes, String> cliDireccion;
    public static volatile SingularAttribute<Clientes, Hoteles> cliHotel;
    public static volatile SingularAttribute<Clientes, String> cliCorreo;
    public static volatile SingularAttribute<Clientes, Integer> cliCodigo;
    public static volatile SingularAttribute<Clientes, String> cliId;

}