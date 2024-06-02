
package modelo.dao;

import Model.entity.Cliente;
import Model.entity.Usuario;
import java.util.List;

/**
 *
 * @author Camilo
 */
public interface ClienteServices {
    
    public List<Cliente> consultarPorNombre(Cliente cliente);
    public int crear(Cliente cliente);
    public int actualizar(Cliente cliente);
    public List<Cliente> listaClientes(Usuario u);
    
}
