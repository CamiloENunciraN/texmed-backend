
package com.mycompany.texmed.i.resources;

import Model.entity.Cliente;
import Model.entity.Usuario;
import controller.ClienteController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Camilo
 */
@Path("api")
public class ClienteResource {
    
    ClienteController cc = new ClienteController();

    @GET  //recibe {id} devuelve {todos los clientes del usuario del id}
    @Path("/cliente/listado/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListadoClientes(@PathParam("id") int id) {
        Usuario u = new Usuario(id);
        List clientes = cc.listaClientes(u);
        return Response
                .status(200)
                .entity(clientes)
                .build();

    }
    
    @GET  //recibe {nombre, id} devuelve {todos los clientes con nombre x del usuario del id}
    @Path("/cliente/busqueda/{nombre}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBusquedaClientesNombre(@PathParam("id") int id_usuario, @PathParam("nombre") String nombre) {
        Cliente c = new Cliente (nombre, id_usuario);
        List clientes = cc.consultarPorNombre(c);
        return Response
                .status(200)
                .entity(clientes)
                .build();

    }
}
