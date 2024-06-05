
package controller;

import Model.entity.Suscripcion;
import modelo.dao.SuscripcionDao;

/**
 *
 * @author camilo
 */
public class SuscripcionController {
    SuscripcionDao sd = new SuscripcionDao();
 
    
    public Suscripcion consultarPorId(Suscripcion suscripcion){
        return sd.consultarPorId(suscripcion);
    }
    
    public int crear(Suscripcion suscripcion){
        return sd.crear(suscripcion);
    }

    public int actualizar(Suscripcion suscripcion){
        return sd.actualizar(suscripcion);
    }
}
