
package Test;

import Model.entity.Suscripcion;
import Model.entity.Usuario;
import java.sql.Date;
import java.time.LocalDate;
import modelo.dao.SuscripcionDao;
import modelo.dao.UsuarioDao;

/**
 *
 * @author Camilo
 */
public class UsuarioTest {
    public static void main(String[] args) {
        UsuarioDao usuario = new UsuarioDao();
        SuscripcionDao sd = new SuscripcionDao();
        Date d = Date.valueOf(LocalDate.now());
        Suscripcion sus = new Suscripcion("Basic", d, null );
        int s = sd.crear(sus);
        sus.setId(s);
        System.out.println("la id de suscripcion es:"+ s);
        Usuario user = new Usuario("camilo", "camilo@correo.com","000000", "55555", sus, true);
        int u = usuario.crear(user);
        System.out.println("la id del usuario es:"+ u);
       // Usuario s = usuario.consultarPorId(user);
        //System.out.println("--"+ s);
       
    }
    
}
