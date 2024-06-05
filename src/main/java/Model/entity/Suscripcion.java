
package Model.entity;

import java.sql.Date;

/**
 *
 * @author Camilo
 */
public class Suscripcion {
    private int id;
    private String tipo;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Suscripcion() {
    }

    public Suscripcion(int id, String tipo, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.tipo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Suscripcion(String tipo, Date fecha_inicio, Date fecha_fin) {
        this.tipo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
    //para el login
    public Suscripcion(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "id=" + id + ", tipo=" + tipo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }
    
    
    
}
