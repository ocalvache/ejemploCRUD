/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiciosRS;

import com.olguer.controllers.EquiposFacade;
import com.olguer.entities.Equipos;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ocalvache
 */
@Path("Equipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RSEquipoServicio {

    @Inject //Luego del constructor
    private EquiposFacade adminEquipo;

    @POST
    //@Path("/opeGua")
    public String guardar(Equipos equipo) {
        try {
            adminEquipo.guardar(equipo);
            return "Equipo guardado correctamente";
        } catch (Exception e) {
            return "Error al guardar el equipo:" + e.getMessage();
        }
    }

    @PUT
    public String actualizar(Equipos equipo) {
        try {
            adminEquipo.actualizar(equipo);
            return "Equipo actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el Equipo:" + e.getMessage();
        }
    }

    @PATCH
    public String actualizarParcial(Equipos equipo) {
        try {
            adminEquipo.actualizar(equipo);
            return "Equipo actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el equipo:" + e.getMessage();
        }
    }

    @GET
    public List<Equipos> consultarTodos() {
        return adminEquipo.consultarTodos();
    }

    @GET
    @Path("/{id}")
    public Equipos consultarPorId(@PathParam("id") Integer id) {
        return adminEquipo.consultarPorId(id);
    }

    @DELETE
    @Path("/{id}")
    public String eliminar(@PathParam("id") Integer id) {
        try {
            adminEquipo.eliminar(adminEquipo.consultarPorId(id));
            return "Equipo eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el Equipo:" + e.getMessage();
        }
    }

}
