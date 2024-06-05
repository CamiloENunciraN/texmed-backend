
package Model.entity;

import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class Cliente {
    private int id;
    private String nombre;
    private String celular;
    private String direccion;
    private int id_usuario;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String celular, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
    }

    public Cliente(int id, String nombre, String celular, String direccion, int id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.id_usuario = id_usuario;
    }

    public Cliente(String nombre, int id_usuario) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", celular=" + celular + ", direccion=" + direccion + ", id_usuario=" + id_usuario + '}';
    }


    
}
