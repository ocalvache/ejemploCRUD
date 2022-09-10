/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olguer.controllers;

import com.olguer.entities.Jugadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ocalvache
 */
@Stateless
public class JugadoresFacade extends AbstractFacade<Jugadores> {

    @PersistenceContext(unitName = "DBFutbol.PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugadoresFacade() {
        super(Jugadores.class);
    }
    
}
