package com.mycompany.pooiiweb.i.resources;

import Model.entity.Usuario;
import controller.UsuarioController;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Camilo
 */
@Path("api")
public class UsuarioResource {
/*
    UsuarioController uc = new UsuarioController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Usuario> usuarios = new ArrayList();
        usuarios = uc.consultar();
        System.out.println("mm" + usuarios);
        return Response
                .status(200)
                .entity(usuarios)
                .build();
    }

    @GET
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioId(@PathParam("id") String id) {
        Usuario usuario = new Usuario(id);
        Usuario usuarioR = uc.consultarId(usuario);
        return Response
                .status(200)
                .entity(usuarioR)
                .build();

    }

    @POST
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Usuario usuario) {
        try {
            uc.crear(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(usuario)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }

    }

    @DELETE
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Usuario usuario = new Usuario(id);
        int i = uc.borrar(usuario);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("no encontro el destino")
                    .build();
        } else {
            return Response
                    .ok("Correcto")
                    .build();
        }
    }

    @PUT
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(Usuario usuario) {
        try {
            uc.actualizar(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(usuario)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }

    }
*/
}
