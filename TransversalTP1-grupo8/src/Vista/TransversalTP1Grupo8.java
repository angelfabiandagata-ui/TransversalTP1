package Vista;

import Modelo.Conexion;
import java.sql.Connection;

public class TransversalTP1Grupo8 {

    public static void main(String[] args) {
        Conexion c = new Conexion("jdbc:mariadb://localhost:3306/sgulp_equipo_8", "root", "");
        Connection con = c.buscarconexion();
    }

}
