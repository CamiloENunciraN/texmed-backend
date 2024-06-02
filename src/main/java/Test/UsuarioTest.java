
package Test;

import Model.entity.Usuario;
import modelo.dao.UsuarioDao;

/**
 *
 * @author Camilo
 */
public class UsuarioTest {
    public static void main(String[] args) {
        UsuarioDao usuario = new UsuarioDao();
        Usuario user = new Usuario(0);
        Usuario u = usuario.consultarPorId(user);
        System.out.println("--"+ u);
       
    }
    
}
