/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ServiciosWeb;

import com.olguer.controllers.EquiposFacade;
import com.olguer.entities.Equipos;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author ocalvache
 */
@WebService(serviceName = "WSEquipo")
public class WSEquipo {

    @Resource
    WebServiceContext wsctx;

    @Inject //Luego del constructor
    private EquiposFacade adminEquipo;

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "WS de Equipos de Futbol " + txt + " !";
    }

    @WebMethod
    public String guardarEquipo(Equipos equipo) {
        String mensaje = null;
        try {
            MessageContext mctx = wsctx.getMessageContext();

            Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
            List<String> usuario = (List<String>) http_headers.get("username");
            List<String> password = (List<String>) http_headers.get("password");

            if (usuario != null && usuario.get(0).equals("oca") && password != null && password.get(0).equals("1234")) {
                adminEquipo.guardar(equipo);
                mensaje = "Equipo guardado correctamente";
                return mensaje;
            } else {
                return "Usuario Incorrecto";
            }
        } catch (Exception e) {
            mensaje = "Error al guardar un equipo:" + e.getMessage();
        }
        return mensaje;
    }

    @WebMethod(operationName = "consultarTodos")
    public List<Equipos> consultar() throws Exception {

        List<Equipos> equipos = new ArrayList<>();
        try {
            equipos = adminEquipo.consultarTodos();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return equipos;

        //return adminEquipo.consultarTodos();
    }

    @WebMethod
    //public String eliminar(@WebParam(name = "idEqui") Integer idEqui) {
    public String eliminar(Integer idEqui) {
        String mensaje = null;
        try {
            adminEquipo.eliminar(adminEquipo.consultarPorId(idEqui));
            mensaje = "Equipo eliminado correctamente";
        } catch (Exception ex) {
            mensaje = "Error al eliminar el Equipo:" + ex.getMessage();
        }
        return mensaje;
    }

    @WebMethod
    public String actualizarEquipo(Equipos equipo) {
        String mensaje = null;
        try {
            adminEquipo.actualizar(equipo);
            mensaje = "Equipo actualizado correctamente";
        } catch (Exception ex) {
            mensaje = "Error al actualizar el Equipo:" + ex.getMessage();
        }
        return mensaje;
    }

}
