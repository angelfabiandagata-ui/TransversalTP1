package Vista;

import Modelo.Alumno;
import Modelo.Conexion;
import Persistencia.AlumnoDatos;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class TransversalTP1Grupo8 {

    public static void main(String[] args) {
        Conexion c = new Conexion("jdbc:mariadb://localhost:3306/sgulp_equipo_8", "root", "");
        Connection con = c.buscarConexion();
        AlumnoDatos al = new AlumnoDatos(con);
//        Alumno alm = new Alumno(1, 47267078, "Serrano", "Lucas", LocalDate.of(2006, Month.MARCH, 31), true);
//        al.guardarAlumno(alm);
        //Prueba borrar alumno
        al.borrarAlumno(1);
        
    }

}
