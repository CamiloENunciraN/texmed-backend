
package modelo.dao;

import Model.entity.Suscripcion;

/**
 *
 * @author Camilo
 */
public interface SuscripcionServices {
    
    public Suscripcion consultarPorId(Suscripcion suscripcion);
    public int crear(Suscripcion suscripcion);
    public int actualizar(Suscripcion suscripcion);

}
