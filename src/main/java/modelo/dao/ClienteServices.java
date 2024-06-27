
package modelo.dao;

import Model.entity.Cliente;
import Model.entity.Medida;
import Model.entity.Usuario;
import java.util.List;

/**
 *
 * @author Camilo
 */
public interface ClienteServices {
    
    public List<Medida> consultarPorNombre(Cliente cliente);
    public int crear(Cliente cliente);
    public int actualizar(Cliente cliente);
    public List<Cliente> listaClientes(Usuario u);
    
}
