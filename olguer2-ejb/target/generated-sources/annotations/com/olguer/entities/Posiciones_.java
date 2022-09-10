package com.olguer.entities;

import com.olguer.entities.Jugadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T22:20:35")
@StaticMetamodel(Posiciones.class)
public class Posiciones_ { 

    public static volatile SingularAttribute<Posiciones, String> descripcion;
    public static volatile ListAttribute<Posiciones, Jugadores> jugadoresList;
    public static volatile SingularAttribute<Posiciones, Integer> id;

}