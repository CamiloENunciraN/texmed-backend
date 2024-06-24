
package modelo.dao;

import Model.entity.Cliente;
import Model.entity.Usuario;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo
 */
public class ClienteDao implements ClienteServices{
    private final String SQL_LISTADOCLIENTES = "SELECT * FROM Cliente WHERE id_usuario = ? ";
    private final String SQL_ACTUALIZAR = "UPDATE Cliente SET nombre = ?, celular = ?, direccion = ? WHERE id = ?";
    private final String SQL_INSERTAR = "INSERT INTO Cliente (nombre, celular, direccion ) VALUES(?, ?, ?)";
    private final String SQL_CONSULTACLIENTESPORNOMBRE = "SELECT * FROM Cliente WHERE id_usuario = ? AND  nombre LIKE ?";
    
    @Override
    public List<Cliente> consultarPorNombre(Cliente c) {
        List<Cliente> clientes = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTACLIENTESPORNOMBRE);
            stm.setInt(1, c.getId_usuario());
            stm.setString(2, "%"+c.getNombre()+"%");
            resultado = stm.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String celular = resultado.getString("celular");
                String direccion = resultado.getString("direccion");
                Cliente cliente = new Cliente(id, nombre, celular, direccion);
                clientes.add(cliente);
            }
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
        return clientes;
    }

    @Override
    public int crear(Cliente cliente) {
        int registro = 0;
        int  id = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTAR,  Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, cliente.getNombre());
            stm.setString(2, cliente.getCelular());
            stm.setString(3, cliente.getDireccion());
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
    public int actualizar(Cliente cliente) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setString(1, cliente.getNombre());
            stm.setString(2, cliente.getCelular());
            stm.setString(3, cliente.getDireccion());
            stm.setInt(4, cliente.getId());
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
    public List<Cliente> listaClientes(Usuario u) {
        List<Cliente> clientes = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_LISTADOCLIENTES);
            stm.setInt(1, u.getId());
            resultado = stm.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String celular = resultado.getString("celular");
                String direccion = resultado.getString("direccion");
                Cliente cliente = new Cliente(id, nombre, celular, direccion);
                clientes.add(cliente);
            }
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
        return clientes;
    }
    
}
