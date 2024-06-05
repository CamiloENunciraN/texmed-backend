
package com.mycompany.texmed.i.resources;

import Model.entity.Medida;
import Model.entity.Usuario;
import controller.MedidaController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Camilo
 */
@Path("api")
public class MedidaResource {
    
    MedidaController mc = new MedidaController();
    
    @GET  //recibe {id} devuelve {la 5 medidas recientes por fecha del usuario id}
    @Path("/medida/listado/recientes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListadoRecientes(@PathParam("id") int id) {
        Usuario u = new Usuario(id);
        List medidas = mc.listaMedidasRecientes(u);
        return Response
                .status(200)
                .entity(medidas)
                .build();

    }
    
    @GET  //recibe {id} devuelve {la 5 medidas visualizadas por fecha del usuario id}
    @Path("/medida/listado/visualizada/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListadoVisualizadas(@PathParam("id") int id) {
        Usuario u = new Usuario(id);
        List medidas = mc.listaMedidasVIsualizadas(u);
        return Response
                .status(200)
                .entity(medidas)
                .build();

    }
    
    @GET  //recibe {id} devuelve {medida}
    @Path("/medida/ver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedida(@PathParam("id") int id) {
        Medida m = new Medida(id);
        Medida medida = mc.consultarPorId(m);
        return Response
                .status(200)
                .entity(medida)
                .build();

    }
    
    //actualizar recientes visaualizadas cada que se vea se actualice
    @PUT//recibe {id} devuelve {msg}
    @Path("/medida/visualizada")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarVisualizacion(Medida medida) {
        try {
            Date d = Date.valueOf(LocalDate.now());
            medida.setFecha_visualizacion(d);
            mc.actualizarVisualizacion(medida);
            return Response
                    .status(Response.Status.CREATED)
                    .entity("Actualizada exitosamente")
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }

    }
    
    //crear
    //actuaizar
}
