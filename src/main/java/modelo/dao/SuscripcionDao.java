
package modelo.dao;

import Model.entity.Suscripcion;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo
 */
public class SuscripcionDao implements SuscripcionServices {
    private final String SQL_CONSULTAID = "SELECT id, tipo, fecha_inicio, fecha_fin  FROM Suscripcion WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Suscripcion (tipo, fecha_inicio, fecha_fin ) VALUES(?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE Suscripcion SET tipo = ?, fecha_inicio = ?, fecha_fin = ? WHERE id = ?";


    @Override
    public Suscripcion consultarPorId(Suscripcion suscripcion) {

        Suscripcion nSuscripcion = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, suscripcion.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String tipo = resultado.getString("tipo");
            Date fecha_inicio = resultado.getDate("fecha_inicio");
            Date fecha_fin = resultado.getDate("fecha_fin");
            
            nSuscripcion = new Suscripcion(id, tipo, fecha_inicio, fecha_fin);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nSuscripcion;
    }
// devolver el id de a suscripcion
    @Override
    public int crear(Suscripcion suscripcion) {
        int registro = 0;
        int  id = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTAR,  Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, suscripcion.getTipo());
            stm.setDate(2, suscripcion.getFecha_inicio());
            stm.setDate(3, suscripcion.getFecha_fin());
            registro = stm.executeUpdate();
            
            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public int actualizar(Suscripcion suscripcion) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, suscripcion.getTipo());
            stm.setDate(2,(Date) suscripcion.getFecha_inicio());
            stm.setDate(3,(Date) suscripcion.getFecha_fin());
            stm.setInt(4, suscripcion.getId());
            registro = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }
    
}
