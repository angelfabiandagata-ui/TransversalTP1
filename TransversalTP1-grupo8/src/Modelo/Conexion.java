package Modelo;

import com.sun.jdi.connect.spi.Connection;
import org.mariadb.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url;
    private String usuario;
    private String password;

    private static Connection conexion = null;

    public Conexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection buscarconexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp","root", ""); 
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("No se puede conectar o no se puedo cargar el driver ");
            }
        }
        return conexion;
    }

}
