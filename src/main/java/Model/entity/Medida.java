
package Model.entity;

import java.sql.Date;

/**
 *
 * @author camilo
 */
public class Medida {
    private int id;
    private Cliente cliente;
    private String tipo_prenda;
    private String unidades;
    private Date fecha_creacion;
    private Date fecha_visualizacion;
    private String anotaciones;
    private Float cuello;
    private Float hombro;
    private Float pecho;
    private Float ancho_espalda;
    private Float largo_manga;
    private Float puno;
    private Float largo_total;
    private Float cintura;
    private Float codo;
    private Float entrepierna;
    private Float rodilla;
    private Float cadera;
    private Float ancho_pierna;
    private String tipo_bolsillo;
    private String tipo_manga;
    private String tipo_cuello;
    private String tipo_botones;
    private String tipo_pretina;
    private String tipo_cinturon;

    public Medida() {
    }

    public Medida(int id) {
        this.id = id;
    }

    public Medida(int id, Cliente cliente, String tipo_prenda) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
    }
    
    // tipo camisa 

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float cuello, Float hombro, Float pecho, Float ancho_espalda, Float largo_manga, Float puno, Float largo_total, Float cintura, String tipo_bolsillo, String tipo_manga, String tipo_cuello, String tipo_botones) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.cuello = cuello;
        this.hombro = hombro;
        this.pecho = pecho;
        this.ancho_espalda = ancho_espalda;
        this.largo_manga = largo_manga;
        this.puno = puno;
        this.largo_total = largo_total;
        this.cintura = cintura;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_manga = tipo_manga;
        this.tipo_cuello = tipo_cuello;
        this.tipo_botones = tipo_botones;
    }
     // tipo chaqueta

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float cuello, Float hombro, Float pecho, Float ancho_espalda, Float largo_manga, Float puno, Float largo_total, Float cintura, Float codo, String tipo_bolsillo, String tipo_manga, String tipo_cuello, String tipo_botones) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.cuello = cuello;
        this.hombro = hombro;
        this.pecho = pecho;
        this.ancho_espalda = ancho_espalda;
        this.largo_manga = largo_manga;
        this.puno = puno;
        this.largo_total = largo_total;
        this.cintura = cintura;
        this.codo = codo;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_manga = tipo_manga;
        this.tipo_cuello = tipo_cuello;
        this.tipo_botones = tipo_botones;
    }
    // tipo pantalon/short

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float largo_total, Float entrepierna, Float rodilla, Float cadera, Float ancho_pierna, String tipo_bolsillo,  String tipo_botones, String tipo_pretina) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.largo_total = largo_total;
        this.entrepierna = entrepierna;
        this.rodilla = rodilla;
        this.cadera = cadera;
        this.ancho_pierna = ancho_pierna;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_botones = tipo_botones;
        this.tipo_pretina = tipo_pretina;
    }
    // tipo falda

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float largo_total, Float cadera, String tipo_bolsillo, String tipo_botones, String tipo_pretina) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.largo_total = largo_total;
        this.cadera = cadera;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_botones = tipo_botones;
        this.tipo_pretina = tipo_pretina;
    }
    // tipo vestido

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float cuello, Float hombro, Float pecho, Float ancho_espalda, Float largo_manga, Float puno, Float largo_total, Float cintura, Float codo, Float entrepierna, Float rodilla, Float cadera, Float ancho_pierna, String tipo_bolsillo, String tipo_manga, String tipo_cuello, String tipo_botones, String tipo_cinturon) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.cuello = cuello;
        this.hombro = hombro;
        this.pecho = pecho;
        this.ancho_espalda = ancho_espalda;
        this.largo_manga = largo_manga;
        this.puno = puno;
        this.largo_total = largo_total;
        this.cintura = cintura;
        this.codo = codo;
        this.entrepierna = entrepierna;
        this.rodilla = rodilla;
        this.cadera = cadera;
        this.ancho_pierna = ancho_pierna;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_manga = tipo_manga;
        this.tipo_cuello = tipo_cuello;
        this.tipo_botones = tipo_botones;
        this.tipo_cinturon = tipo_cinturon;
    }

    public Medida(int id, Cliente cliente, String tipo_prenda, String unidades, Date fecha_creacion, Date fecha_visualizacion, String anotaciones, Float cuello, Float hombro, Float pecho, Float ancho_espalda, Float largo_manga, Float puno, Float largo_total, Float cintura, Float codo, Float entrepierna, Float rodilla, Float cadera, Float ancho_pierna, String tipo_bolsillo, String tipo_manga, String tipo_cuello, String tipo_botones, String tipo_pretina, String tipo_cinturon) {
        this.id = id;
        this.cliente = cliente;
        this.tipo_prenda = tipo_prenda;
        this.unidades = unidades;
        this.fecha_creacion = fecha_creacion;
        this.fecha_visualizacion = fecha_visualizacion;
        this.anotaciones = anotaciones;
        this.cuello = cuello;
        this.hombro = hombro;
        this.pecho = pecho;
        this.ancho_espalda = ancho_espalda;
        this.largo_manga = largo_manga;
        this.puno = puno;
        this.largo_total = largo_total;
        this.cintura = cintura;
        this.codo = codo;
        this.entrepierna = entrepierna;
        this.rodilla = rodilla;
        this.cadera = cadera;
        this.ancho_pierna = ancho_pierna;
        this.tipo_bolsillo = tipo_bolsillo;
        this.tipo_manga = tipo_manga;
        this.tipo_cuello = tipo_cuello;
        this.tipo_botones = tipo_botones;
        this.tipo_pretina = tipo_pretina;
        this.tipo_cinturon = tipo_cinturon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_visualizacion() {
        return fecha_visualizacion;
    }

    public void setFecha_visualizacion(Date fecha_visualizacion) {
        this.fecha_visualizacion = fecha_visualizacion;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public Float getCuello() {
        return cuello;
    }

    public void setCuello(Float cuello) {
        this.cuello = cuello;
    }

    public Float getHombro() {
        return hombro;
    }

    public void setHombro(Float hombro) {
        this.hombro = hombro;
    }

    public Float getPecho() {
        return pecho;
    }

    public void setPecho(Float pecho) {
        this.pecho = pecho;
    }

    public Float getAncho_espalda() {
        return ancho_espalda;
    }

    public void setAncho_espalda(Float ancho_espalda) {
        this.ancho_espalda = ancho_espalda;
    }

    public Float getLargo_manga() {
        return largo_manga;
    }

    public void setLargo_manga(Float largo_manga) {
        this.largo_manga = largo_manga;
    }

    public Float getPuno() {
        return puno;
    }

    public void setPuno(Float puno) {
        this.puno = puno;
    }

    public Float getLargo_total() {
        return largo_total;
    }

    public void setLargo_total(Float largo_total) {
        this.largo_total = largo_total;
    }

    public Float getCintura() {
        return cintura;
    }

    public void setCintura(Float cintura) {
        this.cintura = cintura;
    }

    public Float getCodo() {
        return codo;
    }

    public void setCodo(Float codo) {
        this.codo = codo;
    }

    public Float getEntrepierna() {
        return entrepierna;
    }

    public void setEntrepierna(Float entrepierna) {
        this.entrepierna = entrepierna;
    }

    public Float getRodilla() {
        return rodilla;
    }

    public void setRodilla(Float rodilla) {
        this.rodilla = rodilla;
    }

    public Float getCadera() {
        return cadera;
    }

    public void setCadera(Float cadera) {
        this.cadera = cadera;
    }

    public Float getAncho_pierna() {
        return ancho_pierna;
    }

    public void setAncho_pierna(Float ancho_pierna) {
        this.ancho_pierna = ancho_pierna;
    }

    public String getTipo_bolsillo() {
        return tipo_bolsillo;
    }

    public void setTipo_bolsillo(String tipo_bolsillo) {
        this.tipo_bolsillo = tipo_bolsillo;
    }

    public String getTipo_manga() {
        return tipo_manga;
    }

    public void setTipo_manga(String tipo_manga) {
        this.tipo_manga = tipo_manga;
    }

    public String getTipo_cuello() {
        return tipo_cuello;
    }

    public void setTipo_cuello(String tipo_cuello) {
        this.tipo_cuello = tipo_cuello;
    }

    public String getTipo_botones() {
        return tipo_botones;
    }

    public void setTipo_botones(String tipo_botones) {
        this.tipo_botones = tipo_botones;
    }

    public String getTipo_pretina() {
        return tipo_pretina;
    }

    public void setTipo_pretina(String tipo_pretina) {
        this.tipo_pretina = tipo_pretina;
    }

    public String getTipo_cinturon() {
        return tipo_cinturon;
    }

    public void setTipo_cinturon(String tipo_cinturon) {
        this.tipo_cinturon = tipo_cinturon;
    }

    @Override
    public String toString() {
        return "Medida{" + "id=" + id + ", cliente=" + cliente + ", tipo_prenda=" + tipo_prenda + ", unidades=" + unidades + ", fecha_creacion=" + fecha_creacion + ", fecha_visualizacion=" + fecha_visualizacion + ", anotaciones=" + anotaciones + ", cuello=" + cuello + ", hombro=" + hombro + ", pecho=" + pecho + ", ancho_espalda=" + ancho_espalda + ", largo_manga=" + largo_manga + ", puno=" + puno + ", largo_total=" + largo_total + ", cintura=" + cintura + ", codo=" + codo + ", entrepierna=" + entrepierna + ", rodilla=" + rodilla + ", cadera=" + cadera + ", ancho_pierna=" + ancho_pierna + ", tipo_bolsillo=" + tipo_bolsillo + ", tipo_manga=" + tipo_manga + ", tipo_cuello=" + tipo_cuello + ", tipo_botones=" + tipo_botones + ", tipo_pretina=" + tipo_pretina + ", tipo_cinturon=" + tipo_cinturon + '}';
    }
    
    
    
    
}
