
package modelo.dao;

import Model.entity.Medida;
import Model.entity.Usuario;
import java.util.List;

/**
 *
 * @author Camilo
 */
public interface MedidaServices {
    
    public Medida consultarPorId(Medida medida);
    public List<Medida> listaMedidasRecientes(Usuario usuario);
    public List<Medida> listaMedidasVIsualizadas(Usuario usuario);
    public int crear(Medida medida);
    public int actualizar(Medida medida);
    public int actualizarVisualizacion(Medida medida);
}
