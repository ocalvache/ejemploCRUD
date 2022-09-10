package com.olguer.entities;

import com.olguer.entities.Jugadores;
import com.olguer.entities.Torneo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T22:20:35")
@StaticMetamodel(Equipos.class)
public class Equipos_ { 

    public static volatile ListAttribute<Equipos, Jugadores> jugadoresList;
    public static volatile SingularAttribute<Equipos, Short> id;
    public static volatile SingularAttribute<Equipos, String> nombre;
    public static volatile ListAttribute<Equipos, Torneo> torneoList;

}