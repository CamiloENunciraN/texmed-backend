
package modelo.dao;

import Model.entity.Cliente;
import Model.entity.Medida;
import Model.entity.Usuario;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo
 */
public class MedidaDao implements MedidaServices{
    private final String SQL_CONSULTAID = "SELECT * FROM Medida m, Cliente c WHERE m.id_cliente = c.id AND m.id = ?";
    private final String SQL_CONSULTARECIENTES = "SELECT m.id, m.tipo_prenda, c.nombre FROM Medida m, Cliente c WHERE c.id_usuario = ? ORDER BY fecha_creacion DESC LIMIT 5"; 
    private final String SQL_CONSULTAVISUALIZADAS = "SELECT m.id, m.tipo_prenda, c.nombre FROM Medida m, Cliente c WHERE c.id_usuario = ? ORDER BY fecha_visualizacion DESC LIMIT 5"; 
    private final String SQL_INSERTAR = "INSERT INTO Medida(tipo_prenda, unidades, fecha_creacion, fecha_visualizacion, id_cliente, anotaciones, cuello, hombro, pecho, ancho_espalda, largo_manga, puno, largo_total, cintura, codo, entrepierna, rodilla, cadera, ancho_pierna, tipo_bolsilo, tipo_manga, tipo_cuello, tipo_botones, tipo_pretina, tipo_cinturon) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_ACTUALIZAR = "UPDATE Medida SET tipo_prenda = ?,unidades = ?, fecha_creacion = ?, fecha_visualizacion = ? ,id_cliente = ?,anotaciones = ? , cuello = ?, hombro = ?, pecho = ?, ancho_espalda = ?,largo_manga = ?,puno = ?, largo_total = ?, cintura = ?, codo = ?, entrepierna = ?, rodilla = ?, cadera = ?,ancho_pierna = ?,tipo_bolsilo = ?, tipo_manga = ?, tipo_cuello = ?, tipo_botones = ?, tipo_pretina = ?, tipo_cinturon = ? WHERE id = ?";
    private final String SQL_ACTUALIZARVISUALIZACION = "UPDATE Medida SET fecha_visualizacion = ? WHERE id = ?";
    
    @Override
    public Medida consultarPorId(Medida medida) {
        Medida nMedida = null;
        Cliente nCliente = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, medida.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            
            int id = resultado.getInt("id");
            String tipo_prenda = resultado.getString("tipo_prenda");
            String unidades = resultado.getString("unidades");
            Date fecha_creacion = resultado.getDate("fecha_creacion");
            Date fecha_visualizacion = resultado.getDate("fecha_visualizacion");
            String anotaciones = resultado.getString("anotaciones");
            Float cuello = resultado.getFloat("cuello");
            Float hombro = resultado.getFloat("hombro");
            Float pecho = resultado.getFloat("pecho");
            Float ancho_espalda = resultado.getFloat("ancho_espalda");
            Float largo_manga = resultado.getFloat("largo_manga");
            Float puno = resultado.getFloat("puno");
            Float largo_total = resultado.getFloat("largo_total");
            Float cintura = resultado.getFloat("cintura");
            Float codo = resultado.getFloat("codo");
            Float entrepierna = resultado.getFloat("entrepierna");
            Float rodilla = resultado.getFloat("rodilla");
            Float cadera = resultado.getFloat("cadera");
            Float ancho_pierna = resultado.getFloat("ancho_pierna");
            String tipo_bolsillo = resultado.getString("tipo_bolsillo");
            String tipo_manga = resultado.getString("tipo_manga");
            String tipo_cuello = resultado.getString("tipo_cuello");
            String tipo_botones = resultado.getString("tipo_botones");
            String tipo_pretina = resultado.getString("tipo_pretina");
            String tipo_cinturon = resultado.getString("tipo_cinturon");
            
            int id_cliente = resultado.getInt("id_cliente");
            String nombre_cliente = resultado.getString("nombre_cliente");
            String celular = resultado.getString("celular");
            String direccion = resultado.getString("direccion");
            
            nCliente = new Cliente(id_cliente, nombre_cliente, celular, direccion);
            nMedida = new Medida(id, nCliente , tipo_prenda, unidades, fecha_creacion, fecha_visualizacion, anotaciones, cuello, hombro, pecho, ancho_espalda, largo_manga, puno, largo_total, cintura, codo, entrepierna, rodilla, cadera, ancho_pierna, tipo_bolsillo, tipo_manga, tipo_cuello, tipo_botones, tipo_pretina, tipo_cinturon);

          

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nMedida;
    }

    @Override
    public List<Medida> listaMedidasRecientes(Usuario usuario) {
        List<Medida> medidas = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTARECIENTES);
            stm.setInt(1, usuario.getId());
            resultado = stm.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String tipo_prenda = resultado.getString("tipo_prenda");
                String nombre = resultado.getString("nombre");
                Cliente cliente = new Cliente(nombre);
                Medida medida = new Medida(id, cliente, tipo_prenda);
                medidas.add(medida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medidas;
    }

    @Override
    public List<Medida> listaMedidasVIsualizadas(Usuario usuario) {
        List<Medida> medidas = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAVISUALIZADAS);
            stm.setInt(1, usuario.getId());
            resultado = stm.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String tipo_prenda = resultado.getString("tipo_prenda");
                String nombre = resultado.getString("nombre");
                Cliente cliente = new Cliente(nombre);
                Medida medida = new Medida(id, cliente, tipo_prenda);
                medidas.add(medida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medidas;
    }

    @Override
    public int crear(Medida medida) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, medida.getTipo_prenda());
            stm.setString(2, medida.getUnidades());
            stm.setDate(3, (Date) medida.getFecha_creacion());
            stm.setDate(4, (Date) medida.getFecha_visualizacion());
            stm.setInt(5, medida.getCliente().getId());
            stm.setString(6, medida.getAnotaciones());
            stm.setFloat(7, medida.getCuello());
            stm.setFloat(8, medida.getHombro());
            stm.setFloat(9, medida.getPecho());
            stm.setFloat(10, medida.getAncho_espalda());
            stm.setFloat(11, medida.getLargo_manga());
            stm.setFloat(12, medida.getPuno());
            stm.setFloat(13, medida.getLargo_total());
            stm.setFloat(14, medida.getCintura());
            stm.setFloat(15, medida.getCodo());
            stm.setFloat(16, medida.getEntrepierna());
            stm.setFloat(17, medida.getRodilla());
            stm.setFloat(18, medida.getCadera());
            stm.setFloat(19, medida.getAncho_pierna());
            stm.setString(20, medida.getTipo_bolsillo());
            stm.setString(21, medida.getTipo_manga());
            stm.setString(22, medida.getTipo_cuello());
            stm.setString(23, medida.getTipo_botones());
            stm.setString(24, medida.getTipo_pretina());
            stm.setString(25, medida.getTipo_cinturon());

            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int actualizar(Medida medida) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, medida.getTipo_prenda());
            stm.setString(2, medida.getUnidades());
            stm.setDate(3, (Date) medida.getFecha_creacion());
            stm.setDate(4, (Date) medida.getFecha_visualizacion());
            stm.setString(5, medida.getAnotaciones());
            stm.setFloat(6, medida.getCuello());
            stm.setFloat(7, medida.getHombro());
            stm.setFloat(8, medida.getPecho());
            stm.setFloat(9, medida.getAncho_espalda());
            stm.setFloat(10, medida.getLargo_manga());
            stm.setFloat(11, medida.getPuno());
            stm.setFloat(12, medida.getLargo_total());
            stm.setFloat(13, medida.getCintura());
            stm.setFloat(14, medida.getCodo());
            stm.setFloat(15, medida.getEntrepierna());
            stm.setFloat(16, medida.getRodilla());
            stm.setFloat(17, medida.getCadera());
            stm.setFloat(18, medida.getAncho_pierna());
            stm.setString(19, medida.getTipo_bolsillo());
            stm.setString(20, medida.getTipo_manga());
            stm.setString(21, medida.getTipo_cuello());
            stm.setString(22, medida.getTipo_botones());
            stm.setString(23, medida.getTipo_pretina());
            stm.setString(24, medida.getTipo_cinturon());
            stm.setInt(25, medida.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }
    
    @Override
    public int actualizarVisualizacion(Medida medida) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZARVISUALIZACION);
            stm.setDate(1, medida.getFecha_visualizacion());
            stm.setInt(2, medida.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }
}
