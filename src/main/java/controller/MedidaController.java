
package controller;

import Model.entity.Medida;
import Model.entity.Usuario;
import java.util.List;
import modelo.dao.MedidaDao;

/**
 *
 * @author Camilo
 */
public class MedidaController {
    MedidaDao md= new MedidaDao();
    
    public Medida consultarPorId(Medida medida){
       return  md.consultarPorId(medida);
    }
    public List<Medida> listaMedidasRecientes(Usuario usuario){
        return md.listaMedidasRecientes(usuario);
    }
    public List<Medida> listaMedidasVIsualizadas(Usuario usuario){
        return md.listaMedidasVIsualizadas(usuario);
    }
    public int crear(Medida medida){
        return md.crear(medida);
    }
    public int actualizar(Medida medida){
        return md.actualizar(medida);
    }
}
