
package controller;

import Model.entity.Usuario;
import java.util.List;
import modelo.dao.UsuarioDao;

/**
 *
 * @author camilo
 */
public class UsuarioController {
    UsuarioDao ud = new UsuarioDao();
 
    
    public Usuario consultarPorId(Usuario usuario){
        return ud.consultarPorId(usuario);
    }
    
    public Usuario consultarPorCorreoClave(Usuario usuario){
        return ud.consultarPorCorreoClave(usuario);
    }
    
    public int consultarPorCorreo(Usuario usuario){
        return ud.consultarPorCorreo(usuario);
    }
    
    
    public int crear(Usuario usuario){
        return ud.crear(usuario);
    }

    public int actualizar(Usuario usuario){
        return ud.actualizar(usuario);
    }
    
    public int desactivar(Usuario usuario){
        return ud.desactivar(usuario);
    }
    
    public int cambiarClave(Usuario usuario){
        return ud.cambiarClave(usuario);
    }
    
    public Usuario consultarPorIdClave(Usuario usuario){
        return ud.consultarPorIdClave(usuario);
    }
}
