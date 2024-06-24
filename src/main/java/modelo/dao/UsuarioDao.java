
package modelo.dao;

import Model.entity.Suscripcion;
import Model.entity.Usuario;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo
 */
public class UsuarioDao implements UsuarioServices {

    private final String SQL_CONSULTAID = "SELECT u.id, u.nombre, u.correo, u.tarjeta, u.estado, s.id AS id_suscripcion, s.tipo AS tipo_suscripcion, s.fecha_inicio, s.fecha_fin  FROM Usuario u, Suscripcion s WHERE u.id = s.id AND u.id = ?";
    private final String SQL_CONSULTACORREOCLAVE = "SELECT u.id, s.tipo  u.estado  FROM Usuario u, Suscripcion s WHERE u.id = s.id AND u.correo = ? AND u.clave = ?";
    private final String SQL_INSERTAR = "INSERT INTO Usuario(nombre, correo, clave, tarjeta, id_suscripcion, estado) VALUES(?, ?, ?, ?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE Usuario SET nombre = ?, correo = ?, tarjeta = ? WHERE id = ?";
    private final String SQL_DESACTIVAR = "UPDATE Usuario SET estado = false WHERE id = ? AND clave = ?";
    private final String SQL_ACTUALIZARCLAVE = "UPDATE Usuario SET clave = ? WHERE id = ?";
    private final String SQL_CONSULTAIDCLAVE = "SELECT clave FROM Usuario WHERE id = ?";

    
    @Override
    public Usuario consultarPorId(Usuario usuario) {
        Usuario nUsuario = null;
        Suscripcion nSuscripcion = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, usuario.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String correo = resultado.getString("correo");
            String tarjeta = resultado.getString("tarjeta");
            Boolean estado = resultado.getBoolean("estado");
            int id_suscripcion = resultado.getInt("id_suscripcion");
            String tipo_suscripcion = resultado.getString("tipo_suscripcion");
            Date fecha_inicio = resultado.getDate("fecha_inicio");
            Date fecha_fin = resultado.getDate("fecha_fin");
            
            nSuscripcion = new Suscripcion(id_suscripcion, tipo_suscripcion, fecha_inicio, fecha_fin);
            nUsuario = new Usuario(id, nombre, correo, tarjeta, nSuscripcion, estado);
          

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nUsuario;
    }
    
    @Override
    public Usuario consultarPorCorreoClave(Usuario usuario) {
        Usuario nUsuario = null;
        Suscripcion nSuscripcion = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTACORREOCLAVE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, usuario.getCorreo());
            stm.setString(2, usuario.getClave());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String tipo = resultado.getString("tipo");
            Boolean estado = resultado.getBoolean("estado");
            
            nSuscripcion = new Suscripcion(tipo);
            nUsuario = new Usuario(id, nSuscripcion, estado);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nUsuario;
    }

    @Override
    public int crear(Usuario usuario) {
        int registro = 0;
        int id = 0; 
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTAR,  Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getCorreo());
            stm.setString(3, usuario.getClave());
            stm.setString(4, usuario.getTarjeta());
            stm.setInt(5, usuario.getSuscripcion().getId());
            stm.setBoolean(6, usuario.getEstado());
            registro = stm.executeUpdate();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    @Override
    public int actualizar(Usuario usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getCorreo());
            stm.setString(3, usuario.getTarjeta());
            stm.setInt(4, usuario.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }
    
    @Override
    public int desactivar(Usuario usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_DESACTIVAR);
            stm.setInt(1, usuario.getId());
            stm.setString(2, usuario.getClave());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    @Override
    public int cambiarClave(Usuario usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZARCLAVE);
            stm.setString(1, usuario.getClave());
            stm.setInt(2, usuario.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;   
    }
    @Override
    public Usuario consultarPorIdClave(Usuario usuario) {
        Usuario nUsuario = null;
        Suscripcion nSuscripcion = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAIDCLAVE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, usuario.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            String clave = resultado.getString("clave");

            nUsuario = new Usuario(clave);
          

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(stm);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nUsuario;
    }

}
