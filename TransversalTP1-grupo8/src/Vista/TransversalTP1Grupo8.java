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
        Alumno alm = new Alumno(47267078, "Serrano", "Lucas", LocalDate.of(2006, Month.MARCH, 31), true);
        Alumno alm1 = new Alumno(36881187, "D'Agata", "Fabian", LocalDate.of(1991, Month.NOVEMBER, 29), true);
        Alumno alm2 = new Alumno(45886408, "Amaya", "Leandro", LocalDate.of(2004, Month.SEPTEMBER, 21), true);
        Alumno alm3 = new Alumno(37296838, "Sosa", "Daiana", LocalDate.of(1993, Month.MAY, 31), true);
        Alumno alm4 = new Alumno(44953034, "Miranda", "Teo", LocalDate.of(2003, Month.JUNE, 30), true);
//        al.guardarAlumno(alm);
//        al.guardarAlumno(alm1);
//        al.guardarAlumno(alm2);
//        al.guardarAlumno(alm3);
//        al.guardarAlumno(alm4);
        //Prueba borrar alumno
        al.borrarAlumno(16);
        al.borrarAlumno(17);
        al.borrarAlumno(18);
        al.borrarAlumno(19);
        al.borrarAlumno(20);
        //al.listarAlumnos();
    }

}
