
package controller;

import Model.entity.Cliente;
import Model.entity.Medida;
import Model.entity.Usuario;
import java.util.List;
import modelo.dao.ClienteDao;

/**
 *
 * @author Camilo
 */
public class ClienteController {
        ClienteDao cd = new ClienteDao();
 
    
    public List<Medida> consultarPorNombre(Cliente c){
        return cd.consultarPorNombre(c);
    }
    
    public int crear(Cliente cliente){
        return cd.crear(cliente);
    }

    public int actualizar(Cliente cliente){
        return cd.actualizar(cliente);
    }

    public List<Cliente> listaClientes(Usuario u){
         return cd.listaClientes(u);
    }
}
