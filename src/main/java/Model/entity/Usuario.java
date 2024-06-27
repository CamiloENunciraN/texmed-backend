
package Model.entity;

import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String clave;
    private String tarjeta;
    private Suscripcion suscripcion;
    private Boolean estado;

    public Usuario() {
    }

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(int id, String nombre, String correo, String tarjeta, Suscripcion suscripcion, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tarjeta = tarjeta;
        this.suscripcion = suscripcion;
        this.estado = estado;
    }

    public Usuario(String nombre, String correo, String clave, String tarjeta, Suscripcion suscripcion, Boolean estado) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.tarjeta = tarjeta;
        this.suscripcion = suscripcion;
        this.estado = estado;
    }

    
    //para realizar las consultas por id
    public Usuario(int id) {
        this.id = id;
    }
    // para la consulta por clave correo login y devolver registro de usuario
    public Usuario(int id, Suscripcion suscripcion, Boolean estado) {
        this.id = id;
        this.suscripcion = suscripcion;
        this.estado = estado;
    }
    //para cambiar la clave
    public Usuario(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", tarjeta=" + tarjeta + ", suscripcion=" + suscripcion + ", estado=" + estado + '}';
    }



}
