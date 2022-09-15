/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olguer.entities;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ocalvache
 */
@Entity
@Table(name = "posiciones")
@NamedQueries({
    @NamedQuery(name = "Posiciones.findAll", query = "SELECT p FROM Posiciones p"),
    @NamedQuery(name = "Posiciones.findById", query = "SELECT p FROM Posiciones p WHERE p.id = :id"),
    @NamedQuery(name = "Posiciones.findByDescripcion", query = "SELECT p FROM Posiciones p WHERE p.descripcion = :descripcion")})
public class Posiciones implements Serializable {

    @Size(max = 15)
    @Column(name = "descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "posicionesId")
    private List<Jugadores> jugadoresList;

    public Posiciones() {
    }

    public Posiciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    @JsonbTransient
    public List<Jugadores> getJugadoresList() {
        return jugadoresList;
    }

    public void setJugadoresList(List<Jugadores> jugadoresList) {
        this.jugadoresList = jugadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posiciones)) {
            return false;
        }
        Posiciones other = (Posiciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.olguer.entities.Posiciones[ id=" + id + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
