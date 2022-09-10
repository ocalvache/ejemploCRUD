package com.olguer.entities;

import com.olguer.entities.Equipos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T22:20:35")
@StaticMetamodel(Torneo.class)
public class Torneo_ { 

    public static volatile SingularAttribute<Torneo, String> descripcion;
    public static volatile ListAttribute<Torneo, Equipos> equiposList;
    public static volatile SingularAttribute<Torneo, Integer> id;
    public static volatile SingularAttribute<Torneo, Short> cantidad;

}