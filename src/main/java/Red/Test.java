
package Red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo
 */
public class Test {
    public static void main(String[] args) {
        try{
        BaseDeDatos bd = BaseDeDatos.getInstance();
        Connection connection = bd.getConnection();
        String sql = "SELECT * FROM Usuario";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Nombre: " + resultado.getString("nombre"));
            System.out.println("Correo: " + resultado.getString("correo"));

        }
    } catch (SQLException ex){
            System.out.println("Conexion no exitosa");
        Logger.getLogger(Test.class.getName()). log(Level.SEVERE, null, ex);
        
    }
   }
}

