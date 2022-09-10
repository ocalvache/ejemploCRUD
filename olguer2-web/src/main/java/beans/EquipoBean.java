/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.olguer.controllers.EquiposFacade;
import com.olguer.entities.Equipos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import util.AbstractManagedBean;


/**
 *
 * @author ocalvache
 */
@Named(value = "equipoBean")
@ViewScoped
public class EquipoBean extends AbstractManagedBean implements Serializable {

    private Equipos equipo; // Guardar o Actualizar
    private Equipos equipoSel; //Selecccionar el cargo desde la tabla
    private List<Equipos> listaEquipos; //Desplegar los cargos en la tabla

    @Inject //Luego del constructor
    private EquiposFacade adminEquipo;
    
    
    /**
     * Creates a new instance of EquipoBean
     */
    public EquipoBean() {
        this.equipo = new Equipos(); //Encerando un registro de la tabla
        this.listaEquipos = new ArrayList<>(); //Encerando la lista

    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Equipos getEquipoSel() {
        return equipoSel;
    }

    public void setEquipoSel(Equipos equipoSel) {
        this.equipoSel = equipoSel;
    }

    public List<Equipos> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipos> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

/*
    public EquiposFacade getAdminEquipo() {
        return adminEquipo;
    }

    public void setAdminEquipo(EquiposFacade adminEquipo) {
        this.adminEquipo = adminEquipo;
    }
    
  */  

    /**
     * Método para guardar o actualizar
     */
    public void guardar() {
        try {
            if (equipo.getId() != null) {
                //Actualizar
                adminEquipo.actualizar(equipo);
                anadirInfo("Equipo actualizado correctamente");
            } else {
                //Guardar
                adminEquipo.guardar(equipo);
                anadirInfo("Equipo guardado correctamente");
            }
            cargarEquipos();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }

    /**
     * Método para cargar los cargos
     */
    private void cargarEquipos() {
        this.listaEquipos = adminEquipo.consultarTodos();
    }

    /**
     * Método para seleccionar un cargo
     *
     * @param ev
     */
    public void seleccionarFila(SelectEvent<Equipos> ev) {
        this.equipoSel = ev.getObject();
    }

    /**
     * Método para cargar el cargo seleccionado
     */
    public void editar() {
        if (equipoSel != null) {
            this.equipo = equipoSel;
        } else {
            anadirError("Se debe seleccionar un equipo");
        }
    }

    /**
     * Método para eliminar un cargo
     */
    public void eliminar() {
        try {
            if (equipoSel != null) {
                adminEquipo.eliminar(equipoSel);
                cargarEquipos();
                resetearFormulario();
            } else {
                anadirError("Se debe seleccionar un euipo");
            }
        } catch (Exception e) {
            anadirError("Error al eliminar:" + e.getMessage());
        }
    }

    /**
     * Método para resetear el formulario
     */
    public void resetearFormulario() {
        this.equipo = new Equipos();
        this.equipoSel = null; //No selección
    }

    /**
     * Método para inicializar el formulario
     */
    @PostConstruct
    public void inicializar() {
        cargarEquipos();
    }


    
    
    
    
    
}
