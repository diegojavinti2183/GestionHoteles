package com.gestionhoteles.entidades;

import com.gestionhoteles.entidades.Clientes;
import com.gestionhoteles.entidades.Detalleregistro;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-23T08:31:15")
@StaticMetamodel(Registros.class)
public class Registros_ { 

    public static volatile SingularAttribute<Registros, Date> regFecha;
    public static volatile SingularAttribute<Registros, Date> regFechaing;
    public static volatile SingularAttribute<Registros, Date> regFechamod;
    public static volatile SingularAttribute<Registros, String> regObservacion;
    public static volatile SingularAttribute<Registros, Date> regFechasalida;
    public static volatile SingularAttribute<Registros, Date> regFechainicio;
    public static volatile SingularAttribute<Registros, String> regUsuarioing;
    public static volatile SingularAttribute<Registros, String> regUsuariomod;
    public static volatile CollectionAttribute<Registros, Detalleregistro> detalleregistroCollection;
    public static volatile SingularAttribute<Registros, Clientes> regCliente;
    public static volatile SingularAttribute<Registros, Integer> regNumero;

}