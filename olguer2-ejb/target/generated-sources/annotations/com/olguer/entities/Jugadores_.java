package com.olguer.entities;

import com.olguer.entities.Equipos;
import com.olguer.entities.Posiciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T22:20:35")
@StaticMetamodel(Jugadores.class)
public class Jugadores_ { 

    public static volatile SingularAttribute<Jugadores, Short> numero;
    public static volatile SingularAttribute<Jugadores, Date> fechaNacimiento;
    public static volatile SingularAttribute<Jugadores, String> apellido;
    public static volatile SingularAttribute<Jugadores, Equipos> equiposId;
    public static volatile SingularAttribute<Jugadores, Posiciones> posicionesId;
    public static volatile SingularAttribute<Jugadores, Short> id;
    public static volatile SingularAttribute<Jugadores, String> nombre;

}