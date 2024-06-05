package com.mycompany.texmed.i.resources;

import Model.entity.Suscripcion;
import Model.entity.Usuario;
import controller.SuscripcionController;
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
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Camilo
 */
@Path("api")
public class UsuarioResource {
    
    UsuarioController uc = new UsuarioController();
    SuscripcionController sc = new SuscripcionController();
    
    @GET
    @Path("/ping")
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
    
    @POST //recibe {nombre, correo, clave, tarjeta} devuelve {id, suscripcion, estado}
    @Path("/usuario/registrarse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarse(Usuario usuario) {
        try {
            Date d = Date.valueOf(LocalDate.now());
            Suscripcion sus = new Suscripcion("Basic", d, null );
            int id_suscripcion = sc.crear(sus);
            sus.setId(id_suscripcion);
            usuario.setSuscripcion(sus);
            usuario.setEstado(true);
            int id_usuario = uc.crear(usuario);
            Usuario uRes = new Usuario(id_usuario, sus, true);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(uRes)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }
    
    
    @POST //recibe {correo, clave} devuelve {id, suscripcion, estado}
    @Path("/usuario/iniciarsesion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(Usuario usuario) {
        try {
            Usuario u = uc.consultarPorCorreoClave(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(u)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }
    
    @PUT //recibe {nombre, correo, tarjeta, id} devuelve {msg}
    @Path("/usuario/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Usuario usuario) {
        try {
            uc.actualizar(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity("Usuario actualizado exitosamente")
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }
    
    @PUT //recibe {id, clave, nuevaclave} devuelve {msg}
    @Path("/usuario/cambiarclave")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cambiarClave(Usuario usuario) {
        try {
            Usuario u = uc.consultarPorIdClave(usuario);
            if(u.getClave().equals(usuario.getClave())){
                 uc.cambiarClave(usuario);
                 return Response
                    .status(Response.Status.CREATED)
                    .entity("Clave modificada exitosamente")
                    .build();
            }else{
                 return Response
                    .status(Response.Status.CREATED)
                    .entity("Su clave anterior no coincide")
                    .build(); 
            }
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }
    
    
    @PUT //recibe {id, clave} devuelve {msg}
    @Path("/usuario/desactivar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response desactivar(Usuario usuario) {
        try {
            uc.desactivar(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity("Usuario desactivado exitosamente")
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }
/*

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