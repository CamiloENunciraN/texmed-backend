
package Red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Camilo
 */
public class BaseDeDatos {
//url para entrar a la bd http://18.209.45.69/phpMyAdmin/
    private final static String URL = "jdbc:mysql://18.209.45.69:3306/1150960?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USERNAME = "test";
    private final static String PASSWORD = "test1_*";
    private static BasicDataSource bds = new BasicDataSource();
    private static BaseDeDatos instance;

    public BaseDeDatos() {
        bds.setUrl(URL);
        bds.setUsername(USERNAME);
        bds.setPassword(PASSWORD);
        bds.setMinIdle(5);
        bds.setMaxIdle(10);
        bds.setMaxOpenPreparedStatements(100);
    }

    public static BaseDeDatos getInstance() {
        if (instance == null) {
            instance = new BaseDeDatos();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return bds.getConnection();
    }
    public static void close(Connection con) throws SQLException{
        con.close();
    }

    public static void close(Statement stm) throws SQLException{
        stm.close();
    }

    public static void close(PreparedStatement stm) throws SQLException{
        stm.close();
    }

    public static void close(ResultSet res) throws SQLException{
        res.close();
    }
}
