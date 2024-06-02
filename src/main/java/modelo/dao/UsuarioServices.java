
package modelo.dao;

import Model.entity.Usuario;
import java.util.List;

/**
 *
 * @author Camilo
 */
public interface UsuarioServices {

    public Usuario consultarPorId(Usuario usuario);
    public Usuario consultarPorCorreoClave(Usuario usuario);
    public int crear(Usuario usuario);
    public int actualizar(Usuario usuario);
    public int desactivar(Usuario usuario);
    public int cambiarClave(Usuario usuario);
}
